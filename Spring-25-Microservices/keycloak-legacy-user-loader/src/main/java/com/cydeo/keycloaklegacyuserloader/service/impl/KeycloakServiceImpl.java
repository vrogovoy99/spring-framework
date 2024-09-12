package com.cydeo.keycloaklegacyuserloader.service.impl;

import com.cydeo.keycloaklegacyuserloader.config.KeycloakProperties;
import com.cydeo.keycloaklegacyuserloader.service.KeycloakService;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;
import static org.keycloak.admin.client.CreatedResponseUtil.getCreatedId;

@Service
public class KeycloakServiceImpl implements KeycloakService {

    private final KeycloakProperties keycloakProperties;

    public KeycloakServiceImpl(KeycloakProperties keycloakProperties) {
        this.keycloakProperties = keycloakProperties;
    }

    public void bulkUserLoadFromDataSQL() {

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Human/IdeaProjects/spring/spring-framework-vr/Spring-25-Microservices/keycloak-legacy-user-loader/src/main/resources/data.sql"))) {

            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().startsWith("VALUES") || line.trim().startsWith("(")) {

                    UserRepresentation keycloakUser = new UserRepresentation();

                    String values = line.substring(line.indexOf('(') + 1, line.lastIndexOf(')'));
                    String[] tokens = values.split(",");

                    keycloakUser.setFirstName(tokens[5].trim().replace("'", ""));
                    keycloakUser.setLastName(tokens[6].trim().replace("'", ""));
                    keycloakUser.setUsername(tokens[7].trim().replace("'", ""));
                    keycloakUser.setEmail(tokens[7].trim().replace("'", ""));
                    keycloakUser.setEmailVerified(true);
                    keycloakUser.setEnabled(Boolean.parseBoolean(tokens[9].trim()));

                    CredentialRepresentation credential = new CredentialRepresentation();
                    credential.setType(CredentialRepresentation.PASSWORD);
                    credential.setTemporary(false);
                    credential.setValue(tokens[8].trim().replace("'", ""));

                    keycloakUser.setCredentials(asList(credential));

                    int roleId = Integer.parseInt(tokens[12].trim());

                    String role = null;

                    if (roleId == 1) {
                        role = "Admin";
                    } else if (roleId == 2) {
                        role = "Manager";
                    } else if (roleId == 3) {
                        role = "Employee";
                    }

                    addRole(keycloakUser, role);

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addRole(UserRepresentation keycloakUser, String role) {

        try (Keycloak keycloak = getKeycloakInstance()) {

            RealmResource realmResource = keycloak.realm(keycloakProperties.getRealm());
            UsersResource usersResource = realmResource.users();

            Response result = usersResource.create(keycloakUser);

            String userId = getCreatedId(result);
            ClientRepresentation appClient = realmResource.clients()
                    .findByClientId(keycloakProperties.getClientId()).get(0);

            RoleRepresentation userClientRole = realmResource.clients().get(appClient.getId()) //
                    .roles().get(role).toRepresentation();

            realmResource.users().get(userId).roles().clientLevel(appClient.getId())
                    .add(List.of(userClientRole));
        }

    }

    private Keycloak getKeycloakInstance() {
        return Keycloak.getInstance(
                keycloakProperties.getAuthServerUrl(),
                keycloakProperties.getMasterRealm(),
                keycloakProperties.getMasterUser(),
                keycloakProperties.getMasterUserPswd(),
                keycloakProperties.getMasterClient());
    }

}

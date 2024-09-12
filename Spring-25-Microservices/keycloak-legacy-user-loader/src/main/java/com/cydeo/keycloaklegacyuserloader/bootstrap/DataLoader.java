package com.cydeo.keycloaklegacyuserloader.bootstrap;

import com.cydeo.keycloaklegacyuserloader.service.KeycloakService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final KeycloakService keycloakService;

    public DataLoader(KeycloakService keycloakService) {
        this.keycloakService = keycloakService;
    }

    @Override
    public void run(String... args) throws Exception {
        keycloakService.bulkUserLoadFromDataSQL();
    }

}

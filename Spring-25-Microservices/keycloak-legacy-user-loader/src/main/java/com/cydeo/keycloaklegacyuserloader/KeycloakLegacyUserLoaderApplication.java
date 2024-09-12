package com.cydeo.keycloaklegacyuserloader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KeycloakLegacyUserLoaderApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KeycloakLegacyUserLoaderApplication.class, args);
        context.close();
    }

}

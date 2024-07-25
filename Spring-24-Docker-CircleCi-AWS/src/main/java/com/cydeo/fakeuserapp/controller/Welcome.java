package com.cydeo.fakeuserapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping
    public String welcome(){
        StringBuilder httpResponse = new StringBuilder();
        httpResponse.append("<html><body> <h1>Welcome to fake user app </h1>");
        httpResponse.append("<br><h3>move sensitive info from config.yml to CircleCi > Project Settings > Environment Variables</h3>");
        httpResponse.append("<a href='/api/v1/no-db/random'>no-db page</a><br>");
        httpResponse.append("<a href='/api/v1/with-db/random'>with-db page</a><br>");
        httpResponse.append("</body></html>");
        return httpResponse.toString();

    }
}

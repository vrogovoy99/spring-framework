package com.cydeo.fakeuserapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping()
    public String welcome(){
        StringBuilder response = new StringBuilder("<html><body>");
        response.append("<h1>Welcome</h1>");
        response.append("<a href='/api/v1/no-db/random'>No database</a>");
        response.append("</body></html>");
        return response.toString();
    }
}

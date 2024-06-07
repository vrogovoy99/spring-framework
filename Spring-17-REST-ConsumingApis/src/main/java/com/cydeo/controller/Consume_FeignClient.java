package com.cydeo.controller;

import com.cydeo.client.BeerStout;
import com.cydeo.client.EmployeeClient;
import com.cydeo.client.UserClient;
import com.cydeo.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
public class Consume_FeignClient {

    private final UserClient userClient;
    private final BeerStout beerStout;
    private final EmployeeClient employeeClient;

    public Consume_FeignClient(UserClient userClient, BeerStout beerStout, EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.beerStout = beerStout;
        this.employeeClient = employeeClient;
    }

    @GetMapping("/api/v1/beer")
    public ResponseEntity<ResponseWrapper> getBeer(){

        return ResponseEntity.ok(new ResponseWrapper("BeerList Retrieved",beerStout.getBeer()));
    }

    @GetMapping("/api/v1/user")
    public ResponseEntity<ResponseWrapper> getUsers(){

        return ResponseEntity.ok(new ResponseWrapper("UserList Retrieved",userClient.getUsers()));
    }

    @GetMapping("/api/v1/employee")
    public ResponseEntity<ResponseWrapper> getEmployee(){
        return ResponseEntity.ok(new ResponseWrapper("Successfully retrieved ",employeeClient.getEmployee("6298ebfecd0551211fce37a6")));
    }

}

package com.cydeo.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    public String firstName;
    public String lastName;
    public LocalDate birthday;
    public String email;
    public String password;
    public String address;
    public String address2;
    public String city;
    public String state;
    public String zipCode;
}

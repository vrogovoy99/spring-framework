package com.cydeo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    @NotBlank
    @Size(max = 12, min = 2)
    public String firstName;
    public String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate birthday;
    public String email;
    public String password;
    public String address;
    public String address2;
    public String city;
    public String state;
    public String zipCode;
}

package com.cydeo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Employee {
    String name;
    String department;
    Integer hourlyRate=100;
}

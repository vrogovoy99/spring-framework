package com.cydeo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.function.ToDoubleBiFunction;

@Configuration

@ComponentScan(basePackages = "com.cydeo")
public class AppConfig {

}
//
//TODO
//
//    1-Create new module:    spring-review-project
//        2- Create config,repository,model,service packages
//        3- create Employee class with
//        -name
//        -department
//        -hourlyRate fields
//        4- Create EmployeeRepository interface
//        one abstract method, int getHouryRate()
//        5-Create impl class DBEmployeeRepository (we will assume we are getting info from db)
//        -override the method,
//        -create one employee inside
//        return emp1.getHouryRate()
//        6-Create HoursRepository interface
//        int getHours() abstract method
//        7-Create RegularHours class override method and return 40
//        8- Create Salary Service
//        create calculateRegularySalary() method and print salary (hourlyRate * Regular Hours)(no static values)
//        --------
//        9-Create OvertimeHours class implement hours interface and override method and return 15
//        10-Handle the error when you call calculateRegularSalary method
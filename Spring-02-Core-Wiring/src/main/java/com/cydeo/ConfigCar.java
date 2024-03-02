package com.cydeo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigCar {
    @Bean
    Car car(){
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }
    @Bean
    @Primary
    //person not linked to the car
    Person person(){
        Person p = new Person();
        p.setName("Mike");
        return p;
    }
    @Bean(name = "wired")
    // person wired to a car
    Person personWired(){
        Person p = new Person();
        p.setName("Piter");
        p.setCar(car());
        return p;
    }
}

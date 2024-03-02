package com.cydeo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigCar {
    @Bean
    Car car(){
        System.out.println(">>>> Car is created");
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }
    @Bean
    @Primary
    //person not linked to the car
    Person person(){
        System.out.println(">>>> Person is created");
        Person p = new Person();
        p.setName("Mike");
        return p;
    }
    @Bean(name = "wired")
    // person wired to a car
    Person personWired(){
        System.out.println(">>>>> Wired person is created");
        Person p = new Person();
        p.setName("Piter");
        p.setCar(car());
        return p;
    }

    // autowiring
    @Bean(name = "autoWired")
    // person wired to a car
    Person personAutoWired(Car car){
        System.out.println(">>>>> Wired person is created");
        Person p = new Person();
        p.setName("Pole");
        p.setCar(car);
        return p;
    }

}

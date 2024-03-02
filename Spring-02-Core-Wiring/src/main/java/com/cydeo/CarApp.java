package com.cydeo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarApp {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigCar.class);
//        Car c = container.getBean(Car.class);
        Person p = container.getBean(Person.class);
        System.out.println("Person " + p.getName() + " drives " + p.getCar()); //car is not set - null

        // wired class
        Person pWired = container.getBean("wired", Person.class);
        System.out.println("Person " + pWired.getName() + " drives " + pWired.getCar().getMake());

        // autowiring
        Person pAW = container.getBean("autoWired", Person.class);
        System.out.println("Person " + pAW.getName() + " drives " + pAW.getCar().getMake());
    }
}

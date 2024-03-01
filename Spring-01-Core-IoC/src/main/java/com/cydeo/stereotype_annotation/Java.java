package com.cydeo.stereotype_annotation;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

@Component
public class Java {
    public void getTeachingHours(){
        System.out.println("Total teaching hours for Java is 250");
    }
}

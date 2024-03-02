package com.cydeo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Java {

    // field injections
//@Autowired
//OfficeHours officeHours;

  // constructor injection
    OfficeHours officeHours;

//    @Autowired
//    public Java(OfficeHours officeHours){
//        this.officeHours=officeHours;
//    }


public void getTeachingHours(){
        System.out.println("Weekly teaching hours: " + (20 + officeHours.getHours()));
    }
}

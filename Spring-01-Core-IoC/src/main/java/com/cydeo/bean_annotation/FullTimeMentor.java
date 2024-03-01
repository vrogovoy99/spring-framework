package com.cydeo.bean_annotation;


import lombok.Data;

@Data
public class FullTimeMentor {
    private int x=0;
    private String status = "Fresh Mentor";
public void createAccount(){
    System.out.println("Full time mentor created");
}
}

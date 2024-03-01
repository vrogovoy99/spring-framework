package com.cydeo.bean_annotation;

import lombok.Data;

@Data
public class PartTimeMentor {
    private int rate=0;

    public void createAccount(){
        System.out.println("Part time mentor created");
    }
}

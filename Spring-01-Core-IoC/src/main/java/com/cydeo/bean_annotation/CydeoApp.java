package com.cydeo.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigApp2.class);

        FullTimeMentor ft = container.getBean(FullTimeMentor.class);
        PartTimeMentor pt = container.getBean(PartTimeMentor.class);
        String string=container.getBean(String.class);


        ft.createAccount();
        ft.setX(3);
        pt.createAccount();

        System.out.println(string + " " + ft.getX());

//        Same bean being reused.
        FullTimeMentor ft2 = container.getBean(FullTimeMentor.class);

        System.out.println("ft1 = " + ft.getX() + "; ft2 = " +ft.getX());




    }
}

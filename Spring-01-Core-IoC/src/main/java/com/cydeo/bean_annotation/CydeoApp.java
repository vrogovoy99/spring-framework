package com.cydeo.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigApp2.class);

        FullTimeMentor ft = container.getBean("freshMentor", FullTimeMentor.class);
        PartTimeMentor pt = container.getBean(PartTimeMentor.class);
        String string=container.getBean(String.class);


        ft.createAccount();
        ft.setX(3);
        pt.createAccount();

        System.out.println(string + " " + ft.getX() + " " + ft.getStatus());

// Same bean being reused.
        FullTimeMentor ft2 = container.getBean("seniorMentor", FullTimeMentor.class);

        // beans based on the same class share common class variable (x) but diferentiate bean set property Status

        System.out.println("________________\nft1 = " + ft.getX() + "; ft2 = " +ft.getX());
        System.out.println("ft1 status " + ft.getStatus());
        System.out.println("ft2 status " + ft2.getStatus());
// primary bean output
        System.out.println("________________\nPart time primary rate is " + pt.getRate());
        PartTimeMentor pt2 = container.getBean("prime", PartTimeMentor.class);
        System.out.println("Prime part time rate is " + pt2.getRate());




    }
}

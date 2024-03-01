package com.cydeo.bean_annotation;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigApp {
    @Bean(name = "freshMentor")
    FullTimeMentor fullTimeMentor(){
        System.out.println("freshMentor bean is created");
        return new FullTimeMentor();
    }
    @Bean(name = "seniorMentor")
    FullTimeMentor fullTimeMentor2(){
        System.out.println("seniorMentor bean is created");
        FullTimeMentor ff = new FullTimeMentor();
        ff.setStatus("Senior Mentor");
        return ff;
    }

    @Bean
    @Primary
    PartTimeMentor partTimeMentor(){
        PartTimeMentor pt= new PartTimeMentor();
        pt.setRate(50);
        return pt;
    }
    @Bean(name = "prime")
    PartTimeMentor partTimeMentor2(){
        PartTimeMentor pt= new PartTimeMentor();
        pt.setRate(123);
        return pt;
    }
}

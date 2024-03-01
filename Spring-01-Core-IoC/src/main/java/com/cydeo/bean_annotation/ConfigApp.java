package com.cydeo.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApp {
    @Bean(name = "freshMentor")
    FullTimeMentor fullTimeMentor(){
        return new FullTimeMentor();
    }
    @Bean(name = "seniorMentor")
    FullTimeMentor fullTimeMentor2(){
        FullTimeMentor ff = new FullTimeMentor();
        ff.setStatus("Senior Mentor");
        return ff;
    }

    @Bean
    PartTimeMentor partTimeMentor(){
        return new PartTimeMentor();
    }
}

package com.cydeo.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApp2 {

    @Bean
    String getString(){
        return "Just random text";
    }
}

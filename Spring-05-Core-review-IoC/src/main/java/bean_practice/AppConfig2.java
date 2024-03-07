package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {
    @Bean("PrimeBean")
    public String returnString(){return "This is a bean-string";}
    @Bean("AltBean")
    public String retunNothing(){return "This is alrernative bean-string";}
}

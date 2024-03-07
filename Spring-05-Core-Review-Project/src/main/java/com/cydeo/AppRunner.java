package com.cydeo;

import com.cydeo.config.AppConfig;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HourRepository;
import com.cydeo.service.SalaryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
//        EmployeeRepository employeeRepository = container.getBean(EmployeeRepository.class);
//        HourRepository hourRepository = container.getBean(HourRepository.class);

        SalaryService salaryService=container.getBean(SalaryService.class);
        salaryService.calculateRegularSalary();

    }
}

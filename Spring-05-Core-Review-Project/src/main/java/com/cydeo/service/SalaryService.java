package com.cydeo.service;

import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HourRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {

    EmployeeRepository employeeRepository;
    HourRepository hourRepository;

    public SalaryService(EmployeeRepository employeeRepository, @Qualifier("OVERTIME") HourRepository hourRepository){
        this.employeeRepository=employeeRepository;
        this.hourRepository=hourRepository;
    }
    public void calculateRegularSalary(){
        System.out.println("Salary = " + (employeeRepository.getHourlyRate()*hourRepository.getHours()));
    }
}

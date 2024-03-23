package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Employee;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/register")
    public String createEmployee(Model model){

        model.addAttribute("employee", new Employee());
        model.addAttribute("states", DataGenerator.getAllStates());

        return "employee/employee-create";
    }


    @PostMapping("/list")
    public String captureEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model){


            System.out.println("check mark 1");
        if(bindingResult.hasErrors()) {
//            in case of validation error repeat createEmployee method to call html page
//            model.addAttribute("employee", new Employee()); - not needed since we have employee coming in ModeAttribute
            System.out.println("check mark 2");
            model.addAttribute("states", DataGenerator.getAllStates());

            return "employee/employee-create";
        }

        System.out.println("check mark 3");

        DataGenerator.saveEmployee(employee);
        model.addAttribute("employees", DataGenerator.readAllEmployees());

        return "employee/employee-list";
    }

    @RequestMapping("/")
    public String employeeDefault(){
        return "employee/index";
    }
}

package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

//    @RequestMapping("/register")
    @GetMapping("/register")
    public String register(Model model){

        model.addAttribute("students", DataGenerator.createStudents());
        return "student/register";
    }
//    @RequestMapping("/welcome")
    @GetMapping("/welcome")
    public String welcomePage(){
    return "student/welcome";
    }

}

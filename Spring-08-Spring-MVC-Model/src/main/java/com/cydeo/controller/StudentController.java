package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){

        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");

        String subject = "Collection";
        model.addAttribute("subject", subject);

        int  studentID= new Random().nextInt(1000);
        model.addAttribute("studentID", studentID);

        List<Integer> numbers = new ArrayList<>();
        numbers=Arrays.asList(3,5,7,11,13,17);
        model.addAttribute("numbers", numbers);


        Student student = new Student(1, "Piter", "First");
        model.addAttribute("student", student);

        return "/student/welcome";
    }

    @RequestMapping("/")
    public String defaultPage(){
        return "default.html";
    }
}

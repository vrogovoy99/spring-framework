package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    //example of parameter variable
    @RequestMapping("/teacher-info")//localhost:8080/teacher/teacher-info?subject=math&experience=5
    public String teacherInfo(@RequestParam(value = "subject", required = false ) String subject,
                              @RequestParam(value = "experience", required = false, defaultValue = "2") Integer experience,
                              Model model){
        System.out.println(subject);
        model.addAttribute("subject", subject);
        model.addAttribute("experience", experience);
        return "/teacher/teacher-info";
    }
    //example of path variable
    @RequestMapping("/teacher-info/{subject}/{experience}") //localhost:8080/teacher/teacher-info/history/200
    public String teacherInfoParam(@PathVariable(value = "subject", required = false) String subject,
                              @PathVariable Integer experience,
                              Model model){

        model.addAttribute("subject", subject);
        model.addAttribute("experience", experience);
        return "/teacher/teacher-info";
    }

}

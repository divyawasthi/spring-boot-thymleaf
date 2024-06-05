package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${operatingSystems}")
    private List<String> osystems;
    @GetMapping("/showStudentForm")
    public String studentForm(Model model){
        Student student = new Student();

        model.addAttribute("student",student);
        model.addAttribute("lstos",osystems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student){
        return "student-confirmation";
    }
}

package com.bharath.app.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentController {

    @GetMapping("/getstudent")
    public String getStudentDetail(){
        return "student1";
    }

    @PutMapping("/updatestudent")
    public String updateStudentDetail(){
        return "Successfully updated student1 to student 2";
    }

    @DeleteMapping("/deletestudent")
    public String deleteStudentDetail(){
        return "Successfully deleted student";
    }
}

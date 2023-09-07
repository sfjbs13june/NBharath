package com.bharath.app.controller;

import com.bharath.app.com.bharath.app.model.Student;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class StudentController {

    Map<String,Student> studentMap= new HashMap<String,Student>();

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        studentMap.put(student.getName(),student);
        return student;
    }
;
    @GetMapping("/read")
    public Student readeStudent(@RequestParam("name") String name){
        return studentMap.get(name);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestParam("name") String name,@RequestParam("age") int age){
        Student student= studentMap.get(name);
        student.setAge(age);
        studentMap.put(name,student);
        return student;
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("name") String name){
        studentMap.remove(name);
        return "Student Deleted Successfully";
    }

}
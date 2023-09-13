package com.mongo.app.controller;

import com.mongo.app.module.Student;
import com.mongo.app.repository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRespository studentRespository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Student create(@RequestBody Student student) {
        student = studentRespository.save(student);
        return student;
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public List<Student> readStudent() {
        return studentRespository.findAll();
    }

    @RequestMapping(value = "/read/{name}", method = RequestMethod.GET)
    public Student readByNameStudent(@PathVariable("name") String name) {
        return studentRespository.findByName(name);
    }
}

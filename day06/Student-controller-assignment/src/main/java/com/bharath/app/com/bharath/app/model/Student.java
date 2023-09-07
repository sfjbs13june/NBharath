package com.bharath.app.com.bharath.app.model;

import org.springframework.stereotype.Component;

@Component
public class Student {


    String name;
    String rollNo;
    int age;
    String std;

    public Student(){}

    public Student(String name, String rollNo, int age, String std) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.std = std;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public int getAge() {
        return age;
    }

    public String getStd() {
        return std;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStd(String std) {
        this.std = std;
    }


}
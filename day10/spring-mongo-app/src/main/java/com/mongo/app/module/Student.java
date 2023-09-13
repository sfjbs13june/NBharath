package com.mongo.app.module;

public class Student {
    public Student(String name, String id, String roll) {
        this.name = name;
        this.id = id;
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    String name;
    String id;

    String roll;
}

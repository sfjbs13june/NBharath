package com.mongo.app.repository;

import com.mongo.app.module.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespository extends MongoRepository<Student, String> {

public Student findByName(String name);

public Student save(Student student);

}

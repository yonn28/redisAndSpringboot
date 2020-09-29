package com.example.redisConnection.StudentRepository;

import com.example.redisConnection.models.Student;

import java.util.List;
import java.util.Map;

public interface StudentRepository {

    void save(Student student);
    Map<String,Student> findAll();
    Student findById(String id);
    void update(Student student);
    void delete(String id);
}

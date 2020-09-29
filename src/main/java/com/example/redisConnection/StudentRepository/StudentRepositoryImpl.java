package com.example.redisConnection.StudentRepository;

import com.example.redisConnection.models.Student;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private RedisTemplate<String,Student> redisTemplate;

    private HashOperations hashOperations;

    public StudentRepositoryImpl(RedisTemplate<String,Student> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Student student) {
        hashOperations.put("STUDENT",student.getId(),student);
    }

    @Override
    public Map<String,Student> findAll() {
        return hashOperations.entries("STUDENT");
    }

    @Override
    public Student findById(String id) {
        return (Student) hashOperations.get("STUDENT",id);
    }

    @Override
    public void update(Student student) {
        save(student);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("STUDENTS",id);
    }
}

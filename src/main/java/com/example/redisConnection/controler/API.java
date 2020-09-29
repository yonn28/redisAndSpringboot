package com.example.redisConnection.controler;

import com.example.redisConnection.StudentRepository.StudentRepository;
import com.example.redisConnection.models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class API {
    private StudentRepository studentRepository;

    public API(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/get")
    public Map<String, Student> getall(){
        return studentRepository.findAll();
    }

    @PostMapping(value = "/post",consumes = "application/json")
    public void save(@RequestBody Student student){
        System.out.println(student);
        studentRepository.save(student);
    }

    @PutMapping(value = "/put",consumes = "application/json")
    public void update(@RequestBody Student student){
        System.out.println(student);
        studentRepository.update(student);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        studentRepository.delete(id);
    }

}

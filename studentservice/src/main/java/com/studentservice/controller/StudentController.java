package com.studentservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentservice.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {

        if (id == 1) {
            return new Student(1, "Prasad", "Spring Boot");
        }
        return new Student(id, "Unknown", "Not Assigned");
    }

    @GetMapping
    public List<Student> getAll() {
        return List.of(
            new Student(1, "Prasad", "Spring Boot"),
            new Student(2, "Lakshmi", "Java")
        );
    }
}

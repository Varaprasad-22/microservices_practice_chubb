package com.courserservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courserservice.model.Student;
import com.courserservice.servicecall.StudentClient;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private StudentClient studentClient;

    @GetMapping("/{id}")
    public String getCourseWithStudent(@PathVariable int id) {
        Student s = studentClient.getStudent(id);
        return "Student: " + s.getName() + " ,  Enrolled Course: " + s.getCourse();
    }
}

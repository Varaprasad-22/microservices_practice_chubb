package com.courserservice.servicecall;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.courserservice.model.Student;

@FeignClient(name = "studentservice")
public interface StudentClient {

    @GetMapping("/students/{id}")	
    Student getStudent(@PathVariable int id);
}

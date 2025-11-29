package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Question;
import com.example.service.QuestionService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	
	@GetMapping("/category/{cat}")
	public List<Question> getByCategory(@PathVariable String cat){
		return questionService.getByCategory(cat);
	}
	 @PostMapping
	    public Question addQuestion(@RequestBody Question q) {
	        return questionService.addQuestion(q);
	    }
}

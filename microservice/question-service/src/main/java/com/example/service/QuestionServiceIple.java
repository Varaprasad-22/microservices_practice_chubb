package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Question;
import com.example.repository.QuestionRepository;

@Service
public class QuestionServiceIple implements QuestionService{

	@Autowired
	public QuestionRepository questionRepo;
	
	public Question addQuestion(Question q) {
		return questionRepo.save(q);
	}
	
	public List<Question> getByCategory(String cat){
		return questionRepo.findByCategory(cat);
	}
}

package com.example.service;

import java.util.List;

import com.example.entity.Question;

public interface QuestionService {

	List<Question> getByCategory(String cat);
	Question addQuestion(Question q);
}

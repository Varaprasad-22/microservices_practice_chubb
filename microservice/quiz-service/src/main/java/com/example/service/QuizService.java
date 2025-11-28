package com.example.service;

import java.util.Map;

public interface QuizService {
	 Map<String, Object> generateQuiz(String category, int count);
}

package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.client.QuestionClient;
import com.example.dto.QuestionDto;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuestionClient client;

	public Map<String, Object> generateQuiz(String category, int count) {
		List<QuestionDto> all = client.getByCategory(category);

		List<QuestionDto> selected = all.stream().limit(count).toList();
		Map<String, Object> quiz = new HashMap<>();
		quiz.put("category", category);
		quiz.put("totalQuestions", selected.size());
		quiz.put("questions", selected);

		List<Integer> allIds=selected.stream().map(q->q.getId()).toList();
		Quiz quizToDb = new Quiz();
        quiz.setCategory(category);
        quiz.setQuestionIds(allIds);
        quizRepository.save(quizToDb);
        
		return quiz;
	}
}

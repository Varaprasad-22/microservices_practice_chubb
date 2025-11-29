package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.client.QuestionClient;
import com.example.dto.QuestionDto;
import com.example.entity.Quiz;
import com.example.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuestionClient client;
	
	@Autowired
	private QuizRepository quizRepository;

	public Map<String, Object> generateQuiz(String category, int count) {
		List<QuestionDto> all = client.getByCategory(category);

		List<QuestionDto> selected = all.stream().limit(count).toList();
		Map<String, Object> quiz = new HashMap<>();
		quiz.put("category", category);
		quiz.put("totalQuestions", selected.size());
		quiz.put("questions", selected);
		List<Integer> allIds=selected.stream().map(q->q.getId()).toList();
		Quiz quizToDb = new Quiz();
		quizToDb.setCategory(category);
		quizToDb.setQuestionIds(allIds);
        quizRepository.save(quizToDb);

		return quiz;
	}
}

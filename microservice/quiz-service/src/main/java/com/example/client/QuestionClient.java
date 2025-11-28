package com.example.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.QuestionDto;

@FeignClient(name = "question-service")
public interface QuestionClient {
	@GetMapping("/question/category/{cat}")
    List<QuestionDto> getByCategory(@PathVariable("cat") String category);
}

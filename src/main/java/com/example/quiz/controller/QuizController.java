package com.example.quiz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz.model.QuestionWrapper;
import com.example.quiz.model.Questn;
import com.example.quiz.model.Response;
import com.example.quiz.service.QuizService;

import jakarta.persistence.criteria.Path;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizservice;
	
	@PostMapping("/create")
	public ResponseEntity<String> createquiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title) {
		return quizservice.createQuiz(category,numQ,title);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
		
	return quizservice.getQuizQuestions(id);
		
		
		
	}
	
	// a user submits quiz then from Id get all the Answers from the id 
	// here integer returning is score of the quiz 
	// quiz id and response of user submitted quiz 
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> response) {
		//TODO: process POST request
		
		return quizservice.calculateQuizResult(id,response);
	}
	
	
}

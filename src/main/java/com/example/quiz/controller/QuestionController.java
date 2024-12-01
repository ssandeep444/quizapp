package com.example.quiz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz.model.Questn;
import com.example.quiz.service.QuestionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionservice;
	
	@GetMapping("/allquestion")
	public ResponseEntity<List<Questn>> getAllQuestion() {
	return questionservice.getAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Questn>> getQuestionByCategory(@PathVariable String category) {
		return questionservice.getQuestionbyCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Questn ques) {
		//TODO: process POST request
		
		return questionservice.addQuestion(ques);
	}
	
	

}

package com.example.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quiz.dao.QuestionDao;
import com.example.quiz.model.Questn;



@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questiondao;
	
	public ResponseEntity<List<Questn>> getAllQuestions() {
		try {
		return new ResponseEntity<>(questiondao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Questn>> getQuestionbyCategory(String cat) {
try {
	return new ResponseEntity<>(questiondao.findByCategory(cat),HttpStatus.OK);
} catch (Exception e) {
	// TODO: handle exception
	
	e.printStackTrace();
}
		
return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}
	
	
	public ResponseEntity<String> addQuestion(Questn que) {
		questiondao.save(que);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
		
	}

}

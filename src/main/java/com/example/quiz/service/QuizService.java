package com.example.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quiz.dao.QuestionDao;
import com.example.quiz.dao.QuizDao;
import com.example.quiz.model.QuestionWrapper;
import com.example.quiz.model.Questn;
import com.example.quiz.model.Quiz;
import com.example.quiz.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizdao;
	@Autowired
	QuestionDao questdao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		// TODO Auto-generated method stub
		
		List<Questn> questions = questdao.findRandomQuestionByCategory(category,numQ);
		
		Quiz qu = new Quiz();
		qu.setTitle(title);
		qu.setQuestions(questions);
		
		quizdao.save(qu);
		
		
		return new ResponseEntity<> ("Success" , HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		
	Optional<Quiz> qq = quizdao.findById(id);
	List<Questn> qqstdb = qq.get().getQuestions();
		List<QuestionWrapper> questionsforuse = new ArrayList<>();
		
		for(Questn q :qqstdb) {
		QuestionWrapper qquewrap = new QuestionWrapper(q.getId(), q.getQuestionTitle(),q.getOption1() , q.getOption2(),q.getOption3(), q.getOption4());
		questionsforuse.add(qquewrap);
		}
		return new ResponseEntity<>(questionsforuse,HttpStatus.OK);
		
	}

	public ResponseEntity<Integer> calculateQuizResult(Integer id, List<Response> response) {
		// TODO Auto-generated method stub
		
		// quiz object we are getting in tht we have multiple questions 
		
		Optional<Quiz> quiz = quizdao.findById(id);
		List<Questn> quetios = quiz.get().getQuestions();
		int right = 0 ;
		int i =0;
		for(Response rs : response) {
			
			if(rs.getResponse().equals(quetios.get(i).getRightAnswer()))
				right++;
			
			i++;
		}
		
		
		
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	
	

}

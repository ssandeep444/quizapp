package com.example.quiz.model;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Quiz {
	
	@Id
	@SequenceGenerator(name="quiz_gen" ,sequenceName="quiz_gen_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="quiz_gen")

	private Integer id;
	
	@ManyToMany
	private List<Questn> questions;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Questn> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Questn> questions) {
		this.questions = questions;
	}
	private String title;
	

}

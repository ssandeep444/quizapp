package com.example.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quiz.model.Questn;

@Repository
public interface QuestionDao extends JpaRepository<Questn, Integer> {
	List<Questn> findByCategory(String category);

	@Query(value="select * from (select * from question WHERE category= :category order by dbms_random.random) where  ROWNUM <= :numQ",nativeQuery = true)
	List<Questn> findRandomQuestionByCategory(String category, int numQ);

	
}

package com.jasmine.quizApp.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jasmine.quizApp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
	List<Question> findByCategory(String category);
	
}

package com.jasmine.quizApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasmine.quizApp.dao.QuestionDao;
import com.jasmine.quizApp.model.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;
	
	public List<Question> getAllQuestions() {
		System.out.println(questionDao.findAll());
		return questionDao.findAll();
	}

	public List<Question> getQuestionsByCategory(String category) {
		return questionDao.findByCategory(category);
	}


	
}

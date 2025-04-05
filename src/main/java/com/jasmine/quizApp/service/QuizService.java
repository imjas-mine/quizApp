package com.jasmine.quizApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jasmine.quizApp.dao.QuestionDao;
import com.jasmine.quizApp.dao.QuizDao;
import com.jasmine.quizApp.model.Question;
import com.jasmine.quizApp.model.Quiz;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String level, int numQ, String title) {
		List<Question> questions=questionDao.findRandomQuestionsByLevel(level,numQ);
		
		Quiz quiz=new Quiz();
		
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
}

package com.jasmine.quizApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jasmine.quizApp.dao.QuestionDao;
import com.jasmine.quizApp.model.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
		
		return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK) ;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<>(new ArrayList<Question>(),HttpStatus.BAD_REQUEST) ;
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK) ;
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			return new ResponseEntity<>(new ArrayList<Question>(),HttpStatus.BAD_REQUEST) ;
		
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			
		questionDao.save(question);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("an error occured",HttpStatus.BAD_REQUEST);
	}

	public String deleteQuestionById(Integer id) {
		questionDao.deleteById(id);
		return "successfuly deleted";
	}


	
}

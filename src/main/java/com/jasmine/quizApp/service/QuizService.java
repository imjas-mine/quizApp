package com.jasmine.quizApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.jasmine.quizApp.dao.QuestionDao;
import com.jasmine.quizApp.dao.QuizDao;
import com.jasmine.quizApp.model.Question;
import com.jasmine.quizApp.model.QuestionWrapper;
import com.jasmine.quizApp.model.Quiz;
import com.jasmine.quizApp.model.Response;

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

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz>quiz= quizDao.findById(id);
		List<Question> questionsFromDB=quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser=new ArrayList<QuestionWrapper>();
		for(Question q: questionsFromDB) {
			QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(qw);
		}
		return new ResponseEntity<List<QuestionWrapper>>(questionsForUser,HttpStatus.OK);
	}
	

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz=quizDao.findById(id).get();
		List<Question> questions=quiz.getQuestions();
		int i=0;
		int right=0;
		for(Response response: responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
				right++;
			}
			i++;
		}
		return new ResponseEntity<Integer>(right,HttpStatus.OK);
	}
}

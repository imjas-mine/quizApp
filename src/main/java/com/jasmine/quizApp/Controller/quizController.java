package com.jasmine.quizApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jasmine.quizApp.model.QuestionWrapper;
import com.jasmine.quizApp.model.Response;
import com.jasmine.quizApp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class quizController {
	@Autowired
	QuizService quizService;
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String level, @RequestParam int numQ, @RequestParam String title ){
		return quizService.createQuiz(level,numQ,title);
	}
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
		return quizService.getQuizQuestions(id);
	}
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
		return quizService.calculateResult(id,responses);
	}
}

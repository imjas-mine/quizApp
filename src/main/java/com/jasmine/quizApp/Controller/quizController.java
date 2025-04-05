package com.jasmine.quizApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}

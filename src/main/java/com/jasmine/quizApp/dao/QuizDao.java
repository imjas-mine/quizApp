package com.jasmine.quizApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jasmine.quizApp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}

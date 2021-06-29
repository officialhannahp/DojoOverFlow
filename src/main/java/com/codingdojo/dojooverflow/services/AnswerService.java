package com.codingdojo.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.repos.AnswerRepo;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepo answerRepo;
	
	public Answer newAnswer(Answer a) {
		return answerRepo.save(a);
	}
	
	public List<Answer> allAnswers() {
		return answerRepo.findAll();
		}

}

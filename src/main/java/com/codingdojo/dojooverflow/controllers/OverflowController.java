package com.codingdojo.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;


@Controller
public class OverflowController {
	@Autowired
	private AnswerService answerService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private TagService tagService;
	
	
	@GetMapping("/questions")
	public String dashboard(@ModelAttribute Question question, Model model) {
		List<Question> questions = questionService.allQuestions();
		model.addAttribute("Questions", questions);
//		model.addAttribute("Tags", tags);
		return "dashboard.jsp";
	}

	
	@GetMapping("/questions/new")
	public String newQestion(Model model) {
		model.addAttribute("newQuestion", new Question());
		return "addQuestion.jsp";
	}
	
	@GetMapping("/questions/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Question question = questionService.findQuestion(id);
		model.addAttribute("Tag", tagService.allTags());
		model.addAttribute("Question", question);
		return "show.jsp";
	}
	
	
	
	///////////////////////////////////////////////////////
	
	
	@PostMapping("/addAnswer")
	public String addAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addAnswer.jsp";
		} else {
			answerService.newAnswer(answer);
			return "redirect:/questions/{id}";
		}
	}
	
	
	@PostMapping("/createQuestion")
	public String createQuestion(@Valid @ModelAttribute("newQuestion") Question question, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "addQuestion.jsp";
		} else {
			questionService.newQuestionWithTags(question);
			return "redirect:/questions";
		}
	}
}

package com.codingdojo.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repos.QuestionRepo;
import com.codingdojo.dojooverflow.repos.TagRepo;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Autowired
	private TagRepo tagRepo;
	
	
	public Question newQuestion(Question q) {
		return questionRepo.save(q);
	}
	
	public List<Question> allQuestions() {
		return questionRepo.findAll();
		}

	
	public Question findQuestion(Long id) {
		Optional<Question> optionalQuestion = questionRepo.findById(id);
		if(optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		}else {
			return null;
		}
	}
	
	public Tag createTag(String subject) {
		Optional<Tag> optionalTag = tagRepo.findTagBySubject(subject);
		if(optionalTag.isPresent()) {
			return optionalTag.get();
		} else {
			return tagRepo.save(new Tag(subject));
		}
	}
	
	public Question newQuestionWithTags(Question q) {
		List<Tag> tags = new ArrayList<>();
		for (String tagName: q.getTagsInput().split(",")) {
			tags.add(createTag(tagName));
		}
		q.setTags(tags);
		return questionRepo.save(q);
	}
}

package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repos.TagRepo;

@Service
public class TagService {

	@Autowired
	private TagRepo tagRepo;
	
	public Tag newTag(Tag t) {
		return tagRepo.save(t);
	}
	
	public List<Tag> allTags() {
		return tagRepo.findAll();
		}
	
	public Tag findTag(Long id) {
		Optional<Tag> optionalTag = tagRepo.findById(id);
		if(optionalTag.isPresent()) {
			return optionalTag.get();
		}else {
			return null;
		}
	}
	
}

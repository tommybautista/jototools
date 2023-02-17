package com.jototools.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jototools.models.Idea;
import com.jototools.repositories.IdeaRepository;

@Service
public class IdeaService {
	
	//Dependency Injection - allows to access methods from the Repository Layer
	@Autowired
    private IdeaRepository ideaRepo;
    
	
	//ListAll
	public List<Idea> showAll() {
		return ideaRepo.findAll();
	}

    
    //Create
    public Idea createIdea(Idea idea) {
    	
    	return ideaRepo.save(idea);
    }
   
    
    //Read
    public Idea findIdea(Long id) {
    	return ideaRepo.findById(id).orElse(null);
    }
    
    //Update
    public Idea updateIdea(Idea idea) {
    	return ideaRepo.save(idea);
    }
     
    //Delete
    public void deleteIdea(Long id) {
    	ideaRepo.findById(id).orElse(null);{
    		ideaRepo.deleteById(id);
    	}
    	
    }

}

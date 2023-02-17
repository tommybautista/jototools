package com.jototools.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jototools.models.DayPlanner;

import com.jototools.repositories.DayPlannerRepository;

@Service
public class DayPlannerService {
	
		//Dependency Injection - allows to access methods from the Repository Layer
		@Autowired
	    private DayPlannerRepository plannerRepo;
	    
	    //GetAll
	    public List<DayPlanner> allEvents() {
	    	return(List<DayPlanner>) plannerRepo.findByOrderByDateAsc();
	    }
	    
	    //Create
	    public DayPlanner createEvent(DayPlanner event) {
	    	
	    	return plannerRepo.save(event);
	    }
	   
	    
	    //Read
	    public DayPlanner findEvent(Long id) {
	    	return plannerRepo.findById(id).orElse(null);
	    }
	    
	    //Update
	    public DayPlanner updateEvent(DayPlanner product) {
	    	return plannerRepo.save(product);
	    }
	    
	    //Delete
	    public void deleteEvent(Long id) {
	    	plannerRepo.findById(id).orElse(null);{
	    		plannerRepo.deleteById(id);
	    	}
	    	
	    }
	    
	    //find unique date
	    public Optional<DayPlanner> uniqueDate(DayPlanner event) {
	    	
	    	return plannerRepo.findByDate(event.getDate());
	    	
	    	}
	    
}


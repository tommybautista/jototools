package com.jototools.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jototools.models.StudyGuide;
import com.jototools.repositories.StudyGuideRepository;

@Service
public class StudyGuideService {
	
	//Dependency Injection - allows to access methods from the Repository Layer
	@Autowired
	private StudyGuideRepository studyGuideRepo;
	
	//ListAll
	public List<StudyGuide> showAll() {
		return studyGuideRepo.findAll();
	}
	
	//Create
    public StudyGuide createStudyGuide(StudyGuide studyguide) {
    	
    	return studyGuideRepo.save(studyguide);
    }
   
    
    //Read
    public StudyGuide findStudyGuide(Long id) {
    	return studyGuideRepo.findById(id).orElse(null);
    }
    
    //Update
    public StudyGuide updateStudyGuide(StudyGuide studyguide) {
    	return studyGuideRepo.save(studyguide);
    }
     
    //Delete
    public void deleteStudyGuide(Long id) {
    	studyGuideRepo.findById(id).orElse(null);{
    		studyGuideRepo.deleteById(id);
    	}
    	
    }

    
  
}

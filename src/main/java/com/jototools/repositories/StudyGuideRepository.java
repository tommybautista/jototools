package com.jototools.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jototools.models.StudyGuide;

@Repository
public interface StudyGuideRepository extends CrudRepository<StudyGuide, Long> {
	
	List<StudyGuide> findAll();

}

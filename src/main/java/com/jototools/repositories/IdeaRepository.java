package com.jototools.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jototools.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {
	
	List<Idea> findByUser(String string);
	List<Idea> findAll();

}

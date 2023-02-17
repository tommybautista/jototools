package com.jototools.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jototools.models.DayPlanner;

@Repository
public interface DayPlannerRepository extends CrudRepository<DayPlanner, Long> {
	
	List<DayPlanner> findByOrderByDateAsc();
	Optional <DayPlanner> findByDate (String string);

}

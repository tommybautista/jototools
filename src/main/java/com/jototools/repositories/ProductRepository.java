package com.jototools.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jototools.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findByOrderByCreatedAtDesc();
	List<Product> findByOrderByUpdatedAtDesc();
	List<Product> findAllByCategory(String category);
	List<Product> findAllByUserId(Long id);
    
}

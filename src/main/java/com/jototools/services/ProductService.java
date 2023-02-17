package com.jototools.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jototools.models.Product;
import com.jototools.repositories.ProductRepository;

@Service
public class ProductService {
	
	//Dependency Inject - allows to access methods from the Repository Layer
	@Autowired
    private ProductRepository productRepo;
    
    //GetAll
    public List<Product> allProduct() {
    	return(List<Product>) productRepo.findByOrderByCreatedAtDesc();
    }
    
    //Create
    public Product createProduct(Product b) {
    	return productRepo.save(b);
    }
    
    //Read
    public Product findProduct(Long id) {
    	return productRepo.findById(id).orElse(null);
    }
    
    //Update
    public Product updateProduct(Product product) {
    	return productRepo.save(product);
    }
    
    //Delete
    public String deleteProduct(Long id) {
    	productRepo.findById(id).orElse(null);{
    		productRepo.deleteById(id);
    	}
		return "Item Deleted!";
  
    }
    
    //Find All Categories
    public List<Product> getByCategory(String category) {
    	return productRepo.findAllByCategory(category);
    }
    
    //find all by user
    public List<Product> getByUser(Long id) {
    	return productRepo.findAllByUserId(id);
    }

}


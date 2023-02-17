 package com.jototools.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Name is required!")
    @Size(min=3, max=50, message="Name must be between 3 and 50 characters")
    private String name;
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Product> products;
    
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<DayPlanner> plans;
  
    public User() {
    	
    }
 


	public User(
			@NotEmpty(message = "Name is required!") @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") String name,
			@NotEmpty(message = "Email is required!") @Email(message = "Please enter a valid email!") String email,
			@NotEmpty(message = "Password is required!") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters") String password,
			@NotEmpty(message = "Confirm Password is required!") @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters") String confirm,
			List<Product> products) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.products = products;
	}
	
	









	public Long getId() {
		return id;
	}


















	public String getName() {
		return name;
	}









	public void setName(String name) {
		this.name = name;
	}









	public String getEmail() {
		return email;
	}









	public void setEmail(String email) {
		this.email = email;
	}









	public String getPassword() {
		return password;
	}









	public void setPassword(String password) {
		this.password = password;
	}









	public String getConfirm() {
		return confirm;
	}









	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}









	public Date getCreatedAt() {
		return createdAt;
	}









	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}









	public Date getUpdatedAt() {
		return updatedAt;
	}









	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}









	public List<Product> getProducts() {
		return products;
	}









	public void setProducts(List<Product> products) {
		this.products = products;
	}









	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
  
}

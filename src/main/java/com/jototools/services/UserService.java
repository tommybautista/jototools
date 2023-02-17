package com.jototools.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jototools.models.User;
import com.jototools.models.UserDto;
import com.jototools.models.UserLogin;
import com.jototools.models.UserPage;
import com.jototools.models.UserSearchCriteria;
import com.jototools.repositories.UserCriteriaRepository;
import com.jototools.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	private final UserCriteriaRepository userCriteriaRepository;
	
	@Autowired
    private UserRepository userRepo;
	
	private UserSearchCriteria userSearchCriteria;
	
	public UserService(UserRepository userRepository, UserCriteriaRepository userCriteriaRepository) {
		super();
		this.userRepository = userRepository;
		this.userCriteriaRepository = userCriteriaRepository;
	}

    
//    user find all
    public List<UserDto> allUser() {
    	Iterable<User> iterable = userRepo.findAll();
    	
    	List<UserDto> users = StreamSupport.stream(iterable.spliterator(), false).map(user ->{
    		UserDto dto = new UserDto();
    		BeanUtils.copyProperties(user, dto);
    		return dto;
    	}).collect(Collectors.toList());
    	return users;
    }
    
//  user find all with criteria
  public List<UserDto> allUserWithCriteria(UserPage userPage, UserSearchCriteria userSearchCriteria) {
  	Iterable<User> iterable = userCriteriaRepository.findAllWithFilters(userPage, userSearchCriteria);
  	
  	List<UserDto> users = StreamSupport.stream(iterable.spliterator(), false).map(user ->{
  		UserDto dto = new UserDto();
  		BeanUtils.copyProperties(user, dto);
  		return dto;
  	}).collect(Collectors.toList());
  	return users;
  }
    
//    public Page<User> getUsers(UserPage userPage, UserSearchCriteria userSearchCriteria){
//    	return userCriteriaRepository.findAllWithFilters(userPage, userSearchCriteria);
//    }
    
    public Page<User> getUsers(UserPage userPage, UserSearchCriteria userSearchCriteria){
    	return userCriteriaRepository.findAllWithFilters(userPage, userSearchCriteria);
    }    
    
    public User addUser(User user) {
    	return userRepository.save(user);
    }
    
    //end
    
    public User createUser(User b) {
    	return userRepo.save(b);
    }
    
    public User findUser(Long id) {
    	Optional<User> optionalUser = userRepo.findById(id);
    	if(optionalUser.isPresent()) {
    		return optionalUser.get();
    	}else {
    		return null;
    	}
    }
    
    public User updateUser(User user) {
    	return userRepo.save(user);
    }
    
    public void deleteUser(Long id) {
    	Optional<User> optionalUser = userRepo.findById(id);
    	if(optionalUser.isPresent()) {
    		userRepo.deleteById(id);
    	}
    }
    
    public User findById(Long id) {
    	Optional<User> potentialUser = userRepo.findById(id);
    	if(potentialUser.isPresent()) {
    		return potentialUser.get();
    	}
    	return null;
    }
    
    public User register(User newUser, BindingResult result) {
        
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	
    	if(potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "An account with that email already exists!");
    	}
    	
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	}
    
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
    	
    }
    
    public User login(UserLogin newLogin, BindingResult result) {
    	
    	Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        

    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "User not found!");
    		return null;
    	}
    	
    	User user = potentialUser.get();
        
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	}
    	
        return user;
    }


	public Iterable<User> getAllUsers() {
		Iterable<User> users = userRepo.findAll();
		return users;
	}


	public Iterable<UserDto> getAllUsers(UserPage userPage, UserSearchCriteria usc) {
		Page<User> iterable = userCriteriaRepository.findAllWithFilters(userPage, usc);
	  	
	  	List<UserDto> users = StreamSupport.stream(iterable.spliterator(), false).map(user ->{
	  		UserDto dto = new UserDto();
	  		BeanUtils.copyProperties(user, dto);
	  		return dto;
	  	}).collect(Collectors.toList());
	  	return users;
	}


}


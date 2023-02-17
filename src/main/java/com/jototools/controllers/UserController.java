package com.jototools.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jototools.models.User;
import com.jototools.models.UserDto;
import com.jototools.models.UserPage;
import com.jototools.models.UserSearchCriteria;
import com.jototools.services.UserService;



@RestController
//@Controller
@RequestMapping("/jototools/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@GetMapping("/dashboard")
//	public String UsersDashboard (Model model, UserPage userPage, UserSearchCriteria usc) {
//		
//		Iterable<UserDto> users = userService.getAllUsers(userPage, usc);
//		model.addAttribute("users", users);
//		
//		return "/Users/ShowAll.jsp";
//		
//	}

	
	@GetMapping("/dashboard")
	public ResponseEntity<Iterable<UserDto>> getAllUsers(UserPage userPage, UserSearchCriteria usc){
		return new ResponseEntity<>(userService.getAllUsers(userPage, usc), HttpStatus.OK);
	}

	
	
	@PostMapping("/addUsers")
	public ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
	}


}

package com.jototools.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jototools.models.StudyGuide;
import com.jototools.models.User;
import com.jototools.services.StudyGuideService;
import com.jototools.services.UserService;

@Controller
@RequestMapping("/jototools/studyguide")
public class StudyGuideController {
	
	@Autowired
	private StudyGuideService studyGuideService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping ("/dashboard")
	public String idea(@ModelAttribute("newKey") StudyGuide studyGuide, 
			Model model, HttpSession session) {
		
		User user = userService.findById((Long)session.getAttribute("userSession"));
    	model.addAttribute("user", user);
	
		return "/StudyGuide/Dashboard.jsp";
	}
	
	@PostMapping("/submit")
	public String newIdea(@Valid @ModelAttribute("newKey") StudyGuide studyguide, 
			BindingResult result, Model model, HttpSession session) {
        
    
        if(result.hasErrors()) {
        	return "/StudyGuide/Dashboard.jsp";
        	
        } else {
        	
        	studyGuideService.createStudyGuide(studyguide);
        	}
        
        return "redirect:/jototools/studyguide/dashboard";
    }
	

}

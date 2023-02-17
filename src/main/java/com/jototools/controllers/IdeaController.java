package com.jototools.controllers;

import java.util.List;

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

import com.jototools.models.Idea;
import com.jototools.models.User;
import com.jototools.services.IdeaService;
import com.jototools.services.UserService;


@Controller
@RequestMapping("/jototools/")
public class IdeaController {
	
	@Autowired
	private IdeaService ideaService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping ("/ideasform")
	public String idea(@ModelAttribute("newIdea") Idea idea, 
			Model model, HttpSession session) {
		
		User user = userService.findById((Long)session.getAttribute("userSession"));
    	model.addAttribute("user", user);
	
		return "/JotoTools/IdeasForm.jsp";
	}
	
	@PostMapping("/idea/submit")
	public String newIdea(@Valid @ModelAttribute("newIdea") Idea idea, 
			BindingResult result, Model model, HttpSession session) {
        
    
        if(result.hasErrors()) {
        	return "/JotoTools/IdeasForm.jsp";
        	
        } else {
        	
        	ideaService.createIdea(idea);
        	}
        
        return "redirect:/jototools/ideas";
    }
	
	@GetMapping ("/ideas")
	public String idea(Model model, HttpSession session) {
		
		List<Idea> ideas = ideaService.showAll();
		model.addAttribute("ideas", ideas);
		
		Long userSession = (Long) session.getAttribute("userSession");
		model.addAttribute("user", userService.findById(userSession));
	
		return "/JotoTools/Ideas.jsp";
	}

}

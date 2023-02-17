package com.jototools.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jototools.models.DayPlanner;
import com.jototools.models.User;
import com.jototools.services.DayPlannerService;
import com.jototools.services.UserService;

@Controller
@RequestMapping("/jototools/dayplanner")
public class DayPlannerController {
	
	@Autowired
	private DayPlannerService dayPlannerService;
	
	
	@Autowired
    private UserService userService;
	
	@GetMapping ("/dashboard")
	public String DayPlannerDashboard(Model model, 
			@ModelAttribute("newEvent") DayPlanner event, HttpSession session) {
		
		if(session.getAttribute("userSession") == null) {
			return "redirect:/jototools/logout";
		}
		
		Long userSession = (Long) session.getAttribute("userSession");
		model.addAttribute("user", userService.findById(userSession));
		
		List<DayPlanner> events = dayPlannerService.allEvents();
		model.addAttribute("events", events);
				
		return "/DayPlanner/Dashboard.jsp";
	}
	
	//create
	@PostMapping("/add")
	public String create(
			@Valid @ModelAttribute("newEvent") DayPlanner event, BindingResult result, 
			Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			
			List<DayPlanner> events = dayPlannerService.allEvents();
			model.addAttribute("events", events);
			
			return "/DayPlanner/Dashboard.jsp";
		}
		
		if(dayPlannerService.uniqueDate(event).isPresent()) {
			
			redirectAttributes.addFlashAttribute("error", "An event is already associated with that date! Edit the existing event instead.");

			return "redirect:/jototools/dayplanner/dashboard";
		}
		
		dayPlannerService.createEvent(event);
		
		return "redirect:/jototools/dayplanner/dashboard";
	}
	
	//read or get one
	
	//update
	@GetMapping("/update/{id}")
	public String viewEvent(@PathVariable("id") Long id, Model model, 
			@ModelAttribute("newEvent") DayPlanner event, HttpSession session) {
		model.addAttribute("event", dayPlannerService.findEvent(id));
		
		User user = userService.findById((Long)session.getAttribute("userSession"));
    	model.addAttribute("user", user);
		return "/DayPlanner/Edit.jsp";
	}
	
	@PutMapping("/event/update/{id}")
    public String updateEvent(@PathVariable("id") Long id,Model model, 
    		@Valid @ModelAttribute("newEvent") DayPlanner event,
    		BindingResult result, HttpSession session, RedirectAttributes redirectAttributes) {
		
        if (result.hasErrors()) {
        	model.addAttribute("event", dayPlannerService.findEvent(id));
            return "/DayPlanner/Edit.jsp";
        } else {
        	
        	Long userSession = (Long) session.getAttribute("userSession");
    		model.addAttribute("userSession", userService.findById(userSession));
    		
    		List<DayPlanner> events = dayPlannerService.allEvents();
    		model.addAttribute("events", events);
    		dayPlannerService.updateEvent(event);
            return "redirect:/jototools/dayplanner/dashboard";
        }
    }
	
	
	//delete
	@DeleteMapping("/event/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		dayPlannerService.deleteEvent(id);
		return "redirect:/jototools/dayplanner/dashboard";
	}
	
	//account
	@GetMapping ("/account")
	public String plannerAccount(Model model, HttpSession session) {
		
		if(session.getAttribute("userSession") == null) {
			return "redirect:jototools/logout";
		}
		
		Long userSession = (Long) session.getAttribute("userSession");		
		model.addAttribute("user", userService.findById(userSession));
		
		
		return "/DayPlanner/Account.jsp";
	}
	
	

}


package com.jototools.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jototools.models.User;
import com.jototools.models.UserLogin;
import com.jototools.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping ("/")
	public String index(Model model, HttpSession session) {
		
		if(session.getAttribute("userSession") == null) {
			return "redirect:/jototools/login";
	}
		return "redirect:/jototools/dashboard";
	}
	
	@GetMapping ("/jototools/login")
	public String loginRegister(Model model) {
		model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new UserLogin());
		return "/JotoTools/JotoLogin.jsp";
	}
	
	@GetMapping ("/jototools/register")
	public String register(Model model) {
		model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new UserLogin());
		return "/JotoTools/JotoRegister.jsp";
	}
	
	@PostMapping ("/jototools/login/submit")
	public String login(@Valid @ModelAttribute("newLogin") UserLogin newLogin, 
			BindingResult result, Model model, HttpSession session) {
		
		User user = userService.login(newLogin, result);
		 
	    if(result.hasErrors() || user==null) {
	        model.addAttribute("newUser", new User());
	        return "/JotoTools/JotoLogin.jsp";
	    }
	     
	    session.setAttribute("userSession", user.getId());

    
        return "redirect:/jototools/dashboard";
   
	}
	
	@PostMapping ("/jototools/register/submit")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session) {
		
		User user = userService.register(newUser, result);
		
	    if(result.hasErrors()) {
	        model.addAttribute("newLogin", new UserLogin());
	        return "/JotoTools/JotoRegister.jsp";
	    }
	    
	    session.setAttribute("userSession", user.getId());
	 
	    return "redirect:/jototools/dashboard";
	}
	
	@GetMapping ("/jototools/dashboard")
	public String mainDashboard(Model model, HttpSession session) {
		
		if(session.getAttribute("userSession") == null) {
			return "redirect:/jototools/logout";
		}
		
		Long userSession = (Long) session.getAttribute("userSession");		
		model.addAttribute("user", userService.findById(userSession));
		
		return "/JotoTools/JotoToolsDashboard.jsp";
	}
	
	//show Account
	@GetMapping ("/jototools/account")
	public String mainAccount(Model model, HttpSession session) {
		
		if(session.getAttribute("userSession") == null) {
			return "redirect:jototools/logout";
		}
		
		Long userSession = (Long) session.getAttribute("userSession");
		model.addAttribute("user", userService.findById(userSession));
		
		
		return "/JotoTools/Account.jsp";
	}
	
	//show edit Account form
	@GetMapping("/jototools/edit/{id}")
	public String editAccount(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		Long userSession = (Long) session.getAttribute("userSession");
		model.addAttribute("user", userService.findById(userSession));
		
		model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new UserLogin());
		
		return "/JotoTools/AccountEdit.jsp";
	}
	
	//update account
	@PutMapping("/jototools/account/update/{id}")
    public String updateProduct(@PathVariable("id") Long id,Model model, 
    		@Valid @ModelAttribute("newUser") User user,
    		BindingResult result, HttpSession session) {
		
        if (result.hasErrors()) {
        	model.addAttribute("user", userService.findUser(id));
        	return "/JotoTools/AccountEdit.jsp";
        	
        } else {
        	
        	Long userSession = (Long) session.getAttribute("userSession");
    		model.addAttribute("userSession", userService.findById(userSession));
            userService.updateUser(user);
            return "redirect:/jototools/edit/{id}";
        }
    }
	
	
//	@GetMapping("/jototools/logout")
//	public String logout(HttpSession session) {
//		
//		session.setAttribute("userSession", null);
// 
//	     
//	    return "redirect:/jototools/login";
//	}
	
	@GetMapping("/jototools/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHoldex.;
		if(auth != null) {
//			new SecurityContextLogoutHandler().logout(request, response, auth);
		
		}
 
	     
	    return "redirect:/jototools/login";
	}
	
	@DeleteMapping("/jototools/account/delete/{id}")
	public String userDelete(@PathVariable ("id") Long id, HttpSession session) {
		userService.deleteUser(id);
		session.setAttribute("userSession", null);
		return "redirect:/jototools/login";
		
	}

}


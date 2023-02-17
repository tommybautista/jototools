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


import com.jototools.models.Product;
import com.jototools.models.User;
import com.jototools.services.ProductService;
import com.jototools.services.UserService;


@Controller
@RequestMapping("/jototools/classifieds")
public class ClassifiedsController {
	
	 @Autowired
	    private ProductService productService;
	    
	 @Autowired
	    private UserService userService;
	 
	
	@GetMapping ("/dashboard")
	public String ClassifiedsDashboard(Model model, HttpSession session) {
		
		if(session.getAttribute("userSession") == null) {
			return "redirect:jototools/logout";
		}
		
		Long userSession = (Long) session.getAttribute("userSession");		
		model.addAttribute("user", userService.findById(userSession));
	
		
		return "/Classifieds/Dashboard.jsp";
	}
	
	@GetMapping ("/sell")
	public String ClassifiedsSell(@ModelAttribute("newProduct") Product product, Model model, HttpSession session) {
		model.addAttribute("newProduct", new Product());
		
		User user = userService.findById((Long)session.getAttribute("userSession"));
    	model.addAttribute("user", user);
    	
    	return "/Classifieds/Sell.jsp";
	}
	
	@PostMapping("/sell/submit")
    public String newProduct (@Valid @ModelAttribute("newProduct") Product product, 
    		BindingResult result, Model model, HttpSession session) {
        
    
        if(result.hasErrors()) {
            return "/Classifieds/Sell.jsp";
        } else {
        	
        	productService.createProduct(product);
        }
        
    
        return "redirect:/jototools/classifieds/showall";
    }
	
	@GetMapping ("/view/{id}")
	public String product(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		
		User user = userService.findUser(id);
		model.addAttribute("user", user);
		
		Long userSession = (Long) session.getAttribute("userSession");		
		model.addAttribute("user", userService.findById(userSession));
				
		return "/Classifieds/View.jsp";
	}
	
	
	@GetMapping("/edit/{id}")
	public String ClassifiedsEditProduct(@PathVariable("id") Long id, Model model, 
			@ModelAttribute("newProduct") Product product, HttpSession session) {
		model.addAttribute("product", productService.findProduct(id));
		
		User user = userService.findById((Long)session.getAttribute("userSession"));
    	model.addAttribute("user", user);
		return "/Classifieds/Edit.jsp";
	}
	
	@PutMapping("/product/update/{id}")
    public String updateProduct(@PathVariable("id") Long id,Model model, 
    		@Valid @ModelAttribute("newProduct") Product product,
    		BindingResult result, HttpSession session) {
		
        if (result.hasErrors()) {
        	model.addAttribute("product", productService.findProduct(id));
            return "/Classifieds/Edit.jsp";
        } else {
        	
        	Long userSession = (Long) session.getAttribute("userSession");
    		model.addAttribute("userSession", userService.findById(userSession));
    		
    		List<Product> products = productService.allProduct();
    		model.addAttribute("products", products);
            productService.updateProduct(product);
            return "redirect:/jototools/classifieds/showall";
        }
    }
	
	
	@DeleteMapping("/product/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return "redirect:/jototools/classifieds/showall";
	}
	
	@GetMapping ("/showall")
	public String showAll(Model model, HttpSession session) {
		
		if(session.getAttribute("userSession") == null) {
			return "redirect:jototools/logout";
		}
		
		Long userSession = (Long) session.getAttribute("userSession");
		model.addAttribute("user", userService.findById(userSession));
		
		List<Product> products = productService.allProduct();
		model.addAttribute("products", products);	
		
		return "/Classifieds/ShowAll.jsp";
	}
	
	@GetMapping ("/{category}")
	public String AutoDashboard(@PathVariable("category") String category, Model model, HttpSession session) {
		
		if(session.getAttribute("userSession") == null) {
			return "redirect:jototools/logout";
		}
		
		Long userSession = (Long) session.getAttribute("userSession");		
		model.addAttribute("user", userService.findById(userSession));
		
		List<Product> products = productService.getByCategory(category);
		model.addAttribute("products", products);
	
		
		return "/Classifieds/Categories.jsp";
	}
	
	@GetMapping ("/account")
	public String Account(Model model, HttpSession session) {
		
		if(session.getAttribute("userSession") == null) {
			return "redirect:jototools/logout";
		}
		
		Long userSession = (Long) session.getAttribute("userSession");
		model.addAttribute("user", userService.findById(userSession));
		
		List<Product> products = productService.allProduct();
		model.addAttribute("products", products);
		
		List<Product> allProducts = productService.getByUser(userSession);
		model.addAttribute("products", allProducts);
		
		return "/Classifieds/Account.jsp";
	}

}


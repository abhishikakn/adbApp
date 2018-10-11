package com.verizon.ssd.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {
	
	@GetMapping({"","/","/home"})
	public ModelAndView showHome() {
	ModelAndView mv =  new  ModelAndView("home");
	//to check if current user is aunthenticated
	//to find name
	//predefined class, provides authentication in form of auth obj
	Authentication auth= SecurityContextHolder.getContext().getAuthentication();
	
	//user not yet logged in-anonymous user
	//to retireve user, check if its not anonymours
	//check if user is succesffully authenticated
	
	if(!(auth instanceof AnonymousAuthenticationToken)&& auth.isAuthenticated()) {
		mv.addObject("currentUserName",auth.getName());
		//if user is not authenticated we cant retireve user name
	}
	
	return mv;

}
	@GetMapping("/login")
	public  ModelAndView showLoginPage() {
	return new    ModelAndView("loginPage");	
	}
	
	
	
}
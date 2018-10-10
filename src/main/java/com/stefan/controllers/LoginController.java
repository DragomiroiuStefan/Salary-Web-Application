package com.stefan.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stefan.service.LoginService;
import com.stefan.service.Validation;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpSession session) {
		ModelAndView mv = new ModelAndView();	
		Validation validation = loginService.validateLogin(username, password);	
		if (validation.isSuccessful()) {
			mv.setViewName("forward:/");
			session.setAttribute("username", username);
		}else {
			mv.setViewName("login");
			mv.addObject("message", validation.getErrorMessage());
		}
		return mv;
	}

}

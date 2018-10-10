package com.stefan.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stefan.service.RegisterService;
import com.stefan.service.Validation;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("/register")
	public ModelAndView register(@RequestParam String username, @RequestParam String password, HttpSession session) {
		Validation validation = registerService.registerUser(username, password);
		ModelAndView mv = new ModelAndView();
		if (validation.isSuccessful()) {
			mv.setViewName("forward:/");
			session.setAttribute("username", username);
		}else {
			mv.setViewName("register");
			mv.addObject("message", validation.getErrorMessage());
		}
		return mv;
	}

}

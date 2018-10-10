package com.stefan.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stefan.service.SalaryEntryService;

@Controller
public class HomeController {
	
	@Autowired
	private SalaryEntryService service;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("cities", service.getAllCities());
		mv.addObject("companies", service.getAllCompanies());
		mv.addObject("salaryEntries", service.getLastSalaryEntries());
		return mv;
	}
	
	@RequestMapping("/loginPage")
	public String loginPage(HttpSession session) {
		if (session.getAttribute("username") != null) {
			return "redirect:/";
		}	
		return "login";
	}
	
	@RequestMapping("/registerPage")
	public String registerPage(HttpSession session) {
		if (session.getAttribute("username") != null) {
			return "redirect:/";
		}
		return "register";
	}
	
	@RequestMapping("/addSalaryPage")
	public String addSalaryPage(HttpSession session) {
		if (session.getAttribute("username") == null) {
			return "redirect:/";
		}
		return "addSalary";
	}

}

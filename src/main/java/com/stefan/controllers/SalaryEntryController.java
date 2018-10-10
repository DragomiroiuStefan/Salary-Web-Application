package com.stefan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stefan.service.SalaryEntryService;
import com.stefan.service.Validation;

@Controller
public class SalaryEntryController {
	
	@Autowired
	private SalaryEntryService service;
	
	@RequestMapping("/addSalary")
	public String addSalary(@RequestParam String position, 
							@RequestParam String company, 
							@RequestParam String city, 
							@RequestParam String salary,
							Model model) {
		Validation validation = service.addSalary(position, company, city, salary);
		if (validation.isSuccessful()) {
			return "forward:/";
		} else {
			model.addAttribute("message", validation.getErrorMessage());
			return "addSalary";
		}
	}
	
	@RequestMapping("/searchSalary")
	public ModelAndView searchSalary(@RequestParam String position, 
							   @RequestParam String company, 
							   @RequestParam String city) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("cities", service.getAllCities());
		mv.addObject("companies", service.getAllCompanies());
		mv.addObject("salaryEntries", service.getSearchResults(position, company, city));
		return mv;
	}

}

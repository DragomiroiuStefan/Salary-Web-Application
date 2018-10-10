package com.stefan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefan.model.City;
import com.stefan.model.Company;
import com.stefan.model.SalaryEntry;
import com.stefan.repo.CityRepo;
import com.stefan.repo.CompanyRepo;
import com.stefan.repo.SalaryEntryRepo;

@Service
public class SalaryEntryService {

	@Autowired
	private SalaryEntryRepo sRepo;

	@Autowired
	private CityRepo cityRepo;

	@Autowired
	private CompanyRepo companyRepo;

	public Iterable<City> getAllCities() {
		return cityRepo.findAll();
	}

	public Iterable<Company> getAllCompanies() {
		return companyRepo.findAll();
	}

	public Iterable<SalaryEntry> getAllSalaryEntries() {
		return sRepo.findAll();
	}

	public Iterable<SalaryEntry> getLastSalaryEntries() {
		return sRepo.findFirst20ByOrderByIdDesc();
	}

	public Validation addSalary(String position, String company, String city, String salary) {
		Validation validation = addSalaryValidation(position, company, city, salary);
		if (!validation.isSuccessful()) {
			return validation;
		}
		int s = Integer.parseInt(salary);
		Company companyObj;
		City cityObj;
		if (companyRepo.findById(company).isPresent()) {
			companyObj = companyRepo.findById(company).get();
		} else {
			companyObj = companyRepo.save(new Company(company));
		}
		if (cityRepo.findById(city).isPresent()) {
			cityObj = cityRepo.findById(city).get();
		} else {
			cityObj = cityRepo.save(new City(city));
		}
		SalaryEntry salaryEntry = new SalaryEntry(position,companyObj, cityObj, s);
		sRepo.save(salaryEntry);
		return validation;
	}
	
	private Validation addSalaryValidation(String position, String company, String city, String salary) {
		Validation validation = new Validation();
		if (position == null || position.isEmpty() ||
			company == null || company.isEmpty() ||
			city == null || city.isEmpty() ||
			salary == null || salary.isEmpty()) {
			validation.setErrorMessage("Fields must not be empty");
			return validation;
		}
		try {
			Integer.parseInt(salary);
		} catch (NumberFormatException e) {
			validation.setErrorMessage("Salary must be a number");
			return validation;
		}
		validation.setSuccessful(true);
		return validation;
				
	}
	
	public Iterable<SalaryEntry> getSearchResults(String position, String company, String city) {
		if (position.isEmpty() && company.equals("all") && city.equals("all")) {
			return getAllSalaryEntries();
		} else if (!position.isEmpty() && company.equals("all") && city.equals("all")) {
			return sRepo.findByPosition(position);
		} else if (position.isEmpty() && !company.equals("all") && city.equals("all")) {
			return sRepo.findByCompany_companyName(company);
		} else if (position.isEmpty() && company.equals("all") && !city.equals("all")) {
			return sRepo.findByCity_city(city);			
		} else if (!position.isEmpty() && !company.equals("all") && city.equals("all")) {
			return sRepo.findByPositionAndCompany_companyName(position, company);
		} else if (!position.isEmpty() && company.equals("all") && !city.equals("all")) {
			return sRepo.findByPositionAndCity_city(position, city);
		} else if (position.isEmpty() && !company.equals("all") && !city.equals("all")) {
			return sRepo.findByCompany_companyNameAndCity_city(company, city);
		} else {
			return sRepo.findByPositionAndCompany_companyNameAndCity_city(position, company, city);
		}
	}
}

package com.stefan.repo;

import org.springframework.data.repository.CrudRepository;

import com.stefan.model.SalaryEntry;

public interface SalaryEntryRepo extends CrudRepository<SalaryEntry, Long> {
	
	Iterable<SalaryEntry> findFirst20ByOrderByIdDesc();
	Iterable<SalaryEntry> findByPositionAndCompany_companyNameAndCity_city(String position,String company, String city);
	Iterable<SalaryEntry> findByPosition(String position);
	Iterable<SalaryEntry> findByCompany_companyName(String company);
	Iterable<SalaryEntry> findByCity_city(String city);	
	Iterable<SalaryEntry> findByPositionAndCompany_companyName(String position,String company);
	Iterable<SalaryEntry> findByPositionAndCity_city(String position, String city);
	Iterable<SalaryEntry> findByCompany_companyNameAndCity_city(String company, String city);
}

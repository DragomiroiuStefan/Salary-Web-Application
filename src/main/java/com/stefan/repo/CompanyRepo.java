package com.stefan.repo;

import org.springframework.data.repository.CrudRepository;

import com.stefan.model.Company;

public interface CompanyRepo extends CrudRepository <Company, String>{

}

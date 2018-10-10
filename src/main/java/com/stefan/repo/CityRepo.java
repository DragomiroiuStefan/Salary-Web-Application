package com.stefan.repo;

import org.springframework.data.repository.CrudRepository;

import com.stefan.model.City;

public interface CityRepo extends CrudRepository<City, String>{

}

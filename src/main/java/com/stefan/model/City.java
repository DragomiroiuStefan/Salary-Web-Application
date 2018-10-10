package com.stefan.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
	
	@Id
	private String city;
	private String country;
	
	public City() {}
	
	public City(String city) {
		this.city = city;
	}
	
	public City(String city, String country) {
		this.city = city;
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City [city=" + city + ", country=" + country + "]";
	}

}

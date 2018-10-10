package com.stefan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SalaryEntry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String position;
	@ManyToOne
	private Company company;
	@ManyToOne
	private City city;
	@Column(nullable=false)
	private int salary;
	
	public SalaryEntry() {}
	
	public SalaryEntry(String position, Company company, City city, int salary) {
		this.position = position;
		this.company = company;
		this.city = city;
		this.salary = salary;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "SalaryEntry [id=" + id + ", position=" + position + ", company=" + company + ", city=" + city
				+ ", salary=" + salary + "]";
	}
	
	
}

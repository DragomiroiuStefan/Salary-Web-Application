package com.stefan.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRole {
	
	@Id
	private String role;
	
	public UserRole() {}

	public UserRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [role=" + role + "]";
	}

}

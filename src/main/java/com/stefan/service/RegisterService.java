package com.stefan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefan.model.UserDetails;
import com.stefan.model.UserRole;
import com.stefan.repo.UserDetailsRepo;
import com.stefan.repo.UserRoleRepo;

@Service
public class RegisterService {
	
	@Autowired
	private UserDetailsRepo userRepo;
	
	@Autowired
	private UserRoleRepo roleRepo;
	
	public Validation registerUser(String username, String password) {
		Validation validation = validateRegistration(username, password);
		if (validation.isSuccessful()) {
			saveUser(username, password);
		}
		return validation;
	}
	
	public void saveUser(String username, String password) {
		UserRole role = roleRepo.findById("user").get();
		UserDetails user = new UserDetails(username, password, role);
		System.out.println(user);
		userRepo.save(user);
	}
	
	private Validation validateRegistration(String username, String password) {
		Validation validation = new Validation();
		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            validation.setErrorMessage("Please insert username and password ");
            return validation;
		}
        Optional<UserDetails> user = userRepo.findByUsername(username);
        if (user.isPresent()) {
        	validation.setErrorMessage("Username is taken");
        } else {
        	validation.setSuccessful(true);
        }
        return validation;
	}

}

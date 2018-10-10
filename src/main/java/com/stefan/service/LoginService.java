package com.stefan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefan.model.UserDetails;
import com.stefan.repo.UserDetailsRepo;

@Service
public class LoginService {
	
	@Autowired
	private UserDetailsRepo userRepo;
	
	public Validation validateLogin(String username, String password) {
		Validation validation = new Validation();
		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
			validation.setErrorMessage("Username or password must not be empty");
			return validation;
		}
		Optional<UserDetails> user = userRepo.findByUsername(username);
		if (user.isPresent()) {
			if (user.get().getPassword().equals(password)) {
				validation.setSuccessful(true);
			} else {
				validation.setErrorMessage("Incorrect password");
			}
		} else {
			validation.setErrorMessage("No account with this username");
		}
		return validation;
	}

}

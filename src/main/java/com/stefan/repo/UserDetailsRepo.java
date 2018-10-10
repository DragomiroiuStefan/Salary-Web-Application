package com.stefan.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.stefan.model.UserDetails;

public interface UserDetailsRepo extends CrudRepository<UserDetails, Long> {
	Optional<UserDetails> findByUsername(String username);
}

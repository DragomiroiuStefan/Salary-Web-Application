package com.stefan.repo;

import org.springframework.data.repository.CrudRepository;

import com.stefan.model.UserRole;

public interface UserRoleRepo extends CrudRepository<UserRole, String> {

}

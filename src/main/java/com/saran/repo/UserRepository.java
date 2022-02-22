package com.saran.repo;

import org.springframework.data.repository.CrudRepository;

import com.saran.model.DAOUser;

public interface UserRepository extends CrudRepository<DAOUser,Long> {
	
	DAOUser findByUsername(String username);
}

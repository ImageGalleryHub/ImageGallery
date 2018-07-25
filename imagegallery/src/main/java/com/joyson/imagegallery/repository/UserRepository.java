package com.joyson.imagegallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joyson.imagegallery.model.Users;

/**
 * DAO for Users
 * 
 * @author Joyson De Souza
 *
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	Users findByUsername(String username);
}

package com.joyson.imagegallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joyson.imagegallery.model.Users;

/**
 * DAO for Users
 * 
 * @author Jaison
 *
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}

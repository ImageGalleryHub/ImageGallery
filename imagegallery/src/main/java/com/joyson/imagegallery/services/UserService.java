package com.joyson.imagegallery.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.joyson.imagegallery.model.Users;

/**
 * Basic CRUD operation for Users
 * 
 * @author Joyson De Souza
 *
 */
public interface UserService extends UserDetailsService {

	public void saveUser(Users user);

	public void updateUser(Users user);

	public Users getUser(Long userId);

	public List<Users> getAllUser();
}

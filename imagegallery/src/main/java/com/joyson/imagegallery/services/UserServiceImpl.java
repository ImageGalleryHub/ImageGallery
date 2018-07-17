package com.joyson.imagegallery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.joyson.imagegallery.model.Users;
import com.joyson.imagegallery.repository.UserRepository;

/**
 * Implementation of UserService interface
 * 
 * @author Joyson De Souza
 *
 */
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(final Users user) {
		userRepository.save(user);
	}

	@Override
	public void updateUser(final Users user) {
		userRepository.saveAndFlush(user);

	}

	@Override
	public Users getUser(final Long userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public List<Users> getAllUser() {
		return userRepository.findAll();
	}

}

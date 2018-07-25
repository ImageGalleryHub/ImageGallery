package com.joyson.imagegallery.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(userName);

		if (user == null) {
			throw new UsernameNotFoundException(String.format("The username %s doesn't exist", userName));
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		});

		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), authorities);

		return userDetails;
	}

}

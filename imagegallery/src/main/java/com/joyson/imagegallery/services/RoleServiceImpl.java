package com.joyson.imagegallery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.joyson.imagegallery.model.Role;
import com.joyson.imagegallery.repository.RoleRepository;

/**
 * Role Service
 * 
 * @author Joyson De Souza
 *
 */
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
	}

}

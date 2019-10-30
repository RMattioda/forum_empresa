package com.empresas.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.empresas.forum.entity.User;
import com.empresas.forum.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
			
	public User createUser(User user) {
		encondePassword(user);
		User newUser = userRepo.save(user);
		return newUser;
	}
	
	private void encondePassword(User user) {
		user.setPassword(pe.encode(user.getPassword()));
	}
}

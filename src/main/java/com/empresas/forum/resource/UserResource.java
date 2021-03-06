package com.empresas.forum.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.empresas.forum.entity.User;
import com.empresas.forum.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		
		User newUser = userService.createUser(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("{/id}").buildAndExpand(newUser.getIdentity()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}

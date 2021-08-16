package com.fis.userservice.controller;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.userservice.bean.User;
//import com.fis.springlearn.repository.UserRepository;
//import com.fis.springlearn.service.AppUserDetailsService;

@RestController
@RequestMapping("/users")
public class UserController {

	//@Autowired
	//private AppUserDetailsService appUserDetailsService;

	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		return new User(0, username);
	}

//	@Autowired
//	private UserRepository userRepository;

//	@GetMapping("/{username}")
//	public User findByUsername(@PathVariable String username) {
//		return userRepository.findByUsername(username);
//	}

}

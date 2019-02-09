package com.staroot.mybatis.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staroot.mybatis.domain.User;
import com.staroot.mybatis.domain.UserRepository;


@RestController
@RequestMapping("/api/users")
public class ApiUserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public User show(@PathVariable Long id){
		User user = userRepository.findById(id).get();// it will return an Optional instead of null
		//User user = userRepository.findById(id).orElse(null); // this will return null if you have proper null checks
		return user;
	}
}

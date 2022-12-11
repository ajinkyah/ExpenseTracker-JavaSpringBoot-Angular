package com.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.model.User;
import com.expensetracker.service.UserService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> get() {
		List<User> getUser = this.userService.findAll();
		return new ResponseEntity<List<User>>(getUser, HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> save(@RequestBody User user) {
		User saveUser = this.userService.save(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.OK);
	}
	
}

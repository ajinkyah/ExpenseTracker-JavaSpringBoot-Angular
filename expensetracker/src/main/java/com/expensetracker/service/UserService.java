package com.expensetracker.service;

import java.util.List;

import com.expensetracker.model.User;

public interface UserService {
	
	List<User> findAll();
	
	User save(User user);
}

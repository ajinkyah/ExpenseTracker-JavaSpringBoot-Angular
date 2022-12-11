package com.expensetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.model.User;
import com.expensetracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return this.userRepository.save(user);

		
	}

}

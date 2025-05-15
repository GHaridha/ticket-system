package com.example.ticket_system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ticket_system.model.User;
import com.example.ticket_system.repository.UserRepository;
import com.example.ticket_system.service.UserService;

@Service
public class UserServiceImpl implements UserService{


	@Autowired
    private UserRepository userRepository;

	
	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElseThrow(()->
		  new RuntimeException("User not found with id: " + id));
	}


	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}


	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	@Override
	public User updateUser(Long id, User updatedUser) {
		 User existingUser = userRepository.findById(id)
		            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

		        existingUser.setUsername(updatedUser.getUsername());
		        existingUser.setRole(updatedUser.getRole());
		        existingUser.setPassword(updatedUser.getPassword());
		        return userRepository.save(existingUser);
	}


	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	
}

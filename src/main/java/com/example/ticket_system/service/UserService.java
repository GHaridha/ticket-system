package com.example.ticket_system.service;

import java.util.List;

import com.example.ticket_system.model.User;

public interface UserService {

	    User createUser(User user);          
	    User getUserById(Long id);           
	    List<User> getAllUsers();            
	    User updateUser(Long id, User user); 
	    void deleteUser(Long id);
}

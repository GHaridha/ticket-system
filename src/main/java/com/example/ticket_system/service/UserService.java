package com.example.ticket_system.service;

import java.util.List;

import com.example.ticket_system.dto.UserDTO;
import com.example.ticket_system.model.User;

public interface UserService {

	    UserDTO createUser(UserDTO userDTO);          
	    UserDTO getUserById(Long id);           
	    List<UserDTO> getAllUsers();            
	    UserDTO updateUser(Long id, UserDTO userDTO); 
	    void deleteUser(Long id);
}

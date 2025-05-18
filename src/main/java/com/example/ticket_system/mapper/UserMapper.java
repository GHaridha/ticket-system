package com.example.ticket_system.mapper;

import com.example.ticket_system.dto.UserDTO;
import com.example.ticket_system.model.Ticket;
import com.example.ticket_system.model.User;
import com.example.ticket_system.model.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserMapper {


	 public static UserDTO toDTO(User user) {
	        UserDTO userResponse = new UserDTO();
	        userResponse.setId(user.getId());
	        userResponse.setUsername(user.getUsername());
	        userResponse.setPassword(user.getPassword());
	        userResponse.setRole(user.getRole());
	        return userResponse;
	    }

	  public static User toEntity(UserDTO userDTO) {
	        User user = new User();
	        user.setId(userDTO.getId());
	        user.setUsername(userDTO.getUsername());
	        user.setPassword(userDTO.getPassword());
	        user.setRole(userDTO.getRole());
	        return user;
	    }
}

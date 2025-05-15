package com.example.ticket_system.mapper;

import com.example.ticket_system.dto.TicketResponse;
import com.example.ticket_system.dto.UserResponse;
import com.example.ticket_system.model.Ticket;
import com.example.ticket_system.model.User;

public class UserMapper {


	 public static UserResponse toDTO(User user) {
	        UserResponse userResponse = new UserResponse();
	        userResponse.setId(user.getId());
	        userResponse.setName(user.getUsername());
	        userResponse.setUserRole(user.getRole());
	        return userResponse;
	    }

	    public static User toEntity(UserResponse userResponse) {
	        User user = new User();
	        user.setId(userResponse.getId());
	        user.setUsername(userResponse.getName());
	        user.setRole(userResponse.getUserRole());
	        return user;
	    }
}

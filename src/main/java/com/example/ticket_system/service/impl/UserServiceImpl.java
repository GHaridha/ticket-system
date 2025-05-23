package com.example.ticket_system.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ticket_system.dto.UserDTO;
import com.example.ticket_system.exception.ResourceNotFoundException;
import com.example.ticket_system.mapper.UserMapper;
import com.example.ticket_system.model.User;
import com.example.ticket_system.repository.UserRepository;
import com.example.ticket_system.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = userRepository.save(UserMapper.toEntity(userDTO));
		return UserMapper.toDTO(user);
	}

	@Override
	public UserDTO getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
		return UserMapper.toDTO(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> getAllUsers = userRepository.findAll();
		return getAllUsers.stream().map(t -> UserMapper.toDTO(t)).collect(Collectors.toList());
	}

	@Override
	public UserDTO updateUser(Long id, UserDTO updatedUser) {
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

		existingUser.setUsername(updatedUser.getUsername());
		existingUser.setRole(updatedUser.getRole());
		existingUser.setPassword(updatedUser.getPassword());
		User savedUser = userRepository.save(existingUser);
		return UserMapper.toDTO(savedUser);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}

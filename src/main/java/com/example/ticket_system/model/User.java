package com.example.ticket_system.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	@OneToMany(mappedBy = "assignedTo")
	private Set<Ticket> assignedTickets;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Set<Ticket> getAssignedTickets() {
		return assignedTickets;
	}

	public void setAssignedTickets(Set<Ticket> assignedTickets) {
		this.assignedTickets = assignedTickets;
	}
	
	
}

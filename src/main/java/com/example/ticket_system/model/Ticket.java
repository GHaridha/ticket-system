package com.example.ticket_system.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name ="tickets")
public class Ticket {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String title;

	    @Column(length = 2000)
	    private String description;

	    @Enumerated(EnumType.STRING)
	    private Status status;  

	    @Enumerated(EnumType.STRING)
	    private Priority priority;  

	    private LocalDateTime createdAt;

	    private LocalDateTime updatedAt;

	    @ManyToOne
	    @JoinColumn(name = "assigned_to_id")
	    private User assignedTo;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public Priority getPriority() {
			return priority;
		}

		public void setPriority(Priority priority) {
			this.priority = priority;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(LocalDateTime updatedAt) {
			this.updatedAt = updatedAt;
		}

		public User getAssignedTo() {
			return assignedTo;
		}

		public void setAssignedTo(User assignedTo) {
			this.assignedTo = assignedTo;
		}
	    
	    
}

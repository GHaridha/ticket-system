package com.example.ticket_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ticket_system.model.Ticket;
import java.util.List;


public interface TicketRepository extends JpaRepository<Ticket,Long>{

	List<Ticket> findByCreatedBy(Long userId);
}

package com.example.ticket_system.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ticket_system.model.Ticket;
import com.example.ticket_system.repository.TicketRepository;
import com.example.ticket_system.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{

	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public Ticket createTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public Ticket getTicketById(Long id) {
	    return ticketRepository.findById(id).orElseThrow(() ->
	        new RuntimeException("Ticket not found with id: " + id));
	}

	@Override
	public Ticket updateTicket(Long id, Ticket updatedTicket) {
	    Ticket existingTicket = ticketRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));

	    existingTicket.setTitle(updatedTicket.getTitle());
	    existingTicket.setDescription(updatedTicket.getDescription());
	    existingTicket.setPriority(updatedTicket.getPriority());
	    existingTicket.setStatus(updatedTicket.getStatus());
	    existingTicket.setUpdatedAt(LocalDateTime.now());  // Auto-set updated time
	    existingTicket.setAssignedTo(updatedTicket.getAssignedTo());

	    return ticketRepository.save(existingTicket);
	}

	@Override
	public void deleteTicket(Long id) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(id);
	}

}

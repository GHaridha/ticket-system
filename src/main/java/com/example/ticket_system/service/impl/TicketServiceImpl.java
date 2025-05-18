package com.example.ticket_system.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ticket_system.dto.TicketDTO;
import com.example.ticket_system.mapper.TicketMapper;
import com.example.ticket_system.mapper.UserMapper;
import com.example.ticket_system.model.Ticket;
import com.example.ticket_system.repository.TicketRepository;
import com.example.ticket_system.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Override
	public TicketDTO createTicket(TicketDTO ticketDTO) {
		Ticket ticket = ticketRepository.save(TicketMapper.toEntity(ticketDTO,
				UserMapper.toEntity(userServiceImpl.getUserById(ticketDTO.getAssignedToUserId()))));
		return TicketMapper.toDTO(ticket);
	}

	@Override
	public List<TicketDTO> getAllTickets() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll().stream().map(t ->TicketMapper.toDTO(t) ).collect(Collectors.toList());
	}

	@Override
	public TicketDTO getTicketById(Long id) {
		 Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));
		 return TicketMapper.toDTO(ticket);
	}

	@Override
	public TicketDTO updateTicket(Long id, TicketDTO updatedTicket) {
		Ticket existingTicket = ticketRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));

		existingTicket.setTitle(updatedTicket.getTitle());
		existingTicket.setDescription(updatedTicket.getDescription());
		existingTicket.setPriority(updatedTicket.getPriority());
		existingTicket.setStatus(updatedTicket.getStatus());
		existingTicket.setUpdatedAt(LocalDateTime.now()); // Auto-set updated time
		existingTicket.setAssignedTo(UserMapper.toEntity(userServiceImpl.getUserById(updatedTicket.getAssignedToUserId())));

		Ticket ticket = ticketRepository.save(existingTicket);
		return TicketMapper.toDTO(ticket);
	}

	@Override
	public void deleteTicket(Long id) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(id);
	}

}

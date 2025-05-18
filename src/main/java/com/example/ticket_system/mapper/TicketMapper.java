package com.example.ticket_system.mapper;

import com.example.ticket_system.dto.TicketDTO;
import com.example.ticket_system.model.Priority;
import com.example.ticket_system.model.Ticket;
import com.example.ticket_system.model.User;

public class TicketMapper {

	public static TicketDTO toDTO(Ticket ticket) {
		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO.setId(ticket.getId());
		ticketDTO.setTitle(ticket.getTitle());
		ticketDTO.setDescription(ticket.getDescription());
		ticketDTO.setPriority(ticket.getPriority()); 
		ticketDTO.setStatus(ticket.getStatus());
        if (ticket.getAssignedTo() != null) {
        	ticketDTO.setAssignedToUserId(ticket.getAssignedTo().getId());
        }
        return ticketDTO;
    }

    public static Ticket toEntity(TicketDTO ticketDTO, User assignedUser) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDTO.getId());
        ticket.setTitle(ticketDTO.getTitle());
        ticket.setDescription(ticketDTO.getDescription());
        ticket.setPriority(ticketDTO.getPriority());
        ticket.setStatus(ticketDTO.getStatus());
        ticket.setAssignedTo(assignedUser);
        return ticket;
    }
}

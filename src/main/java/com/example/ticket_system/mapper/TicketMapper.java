package com.example.ticket_system.mapper;

import com.example.ticket_system.dto.TicketResponse;
import com.example.ticket_system.model.Priority;
import com.example.ticket_system.model.Ticket;
import com.example.ticket_system.model.User;

public class TicketMapper {

	public static TicketResponse toDTO(Ticket ticket) {
		TicketResponse ticketResponse = new TicketResponse();
		ticketResponse.setId(ticket.getId());
		ticketResponse.setTitle(ticket.getTitle());
		ticketResponse.setDescription(ticket.getDescription());
		ticketResponse.setPriority(ticket.getPriority()); 
		ticketResponse.setStatus(ticket.getStatus());
        if (ticket.getAssignedTo() != null) {
        	ticketResponse.setCreatedBy(ticket.getAssignedTo().getId());
        }
        return ticketResponse;
    }

    public static Ticket toEntity(TicketResponse ticketResponse, User assignedUser) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketResponse.getId());
        ticket.setTitle(ticketResponse.getTitle());
        ticket.setDescription(ticketResponse.getDescription());
        ticket.setPriority(ticketResponse.getPriority());
        ticket.setStatus(ticketResponse.getStatus());
        ticket.setAssignedTo(assignedUser);
        return ticket;
    }
}

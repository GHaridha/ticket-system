package com.example.ticket_system.service;

import java.util.List;

import com.example.ticket_system.dto.TicketDTO;
import com.example.ticket_system.model.Ticket;

public interface TicketService {

	TicketDTO createTicket(TicketDTO ticketDTO);

    List<TicketDTO> getAllTickets();

    TicketDTO getTicketById(Long id);

    TicketDTO updateTicket(Long id, TicketDTO ticketDTO);

    void deleteTicket(Long id);
}

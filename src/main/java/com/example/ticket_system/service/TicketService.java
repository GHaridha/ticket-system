package com.example.ticket_system.service;

import java.util.List;
import com.example.ticket_system.model.Ticket;

public interface TicketService {

	Ticket createTicket(Ticket ticket);

    List<Ticket> getAllTickets();

    Ticket getTicketById(Long id);

    Ticket updateTicket(Long id, Ticket ticket);

    void deleteTicket(Long id);
}

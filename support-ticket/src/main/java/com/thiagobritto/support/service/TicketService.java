package com.thiagobritto.support.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thiagobritto.support.domain.Ticket;
import com.thiagobritto.support.domain.TicketStatus;
import com.thiagobritto.support.domain.TicketStatusHistory;
import com.thiagobritto.support.repository.TicketRepository;
import com.thiagobritto.support.repository.TicketStatusHistoryRepository;

@Service
public class TicketService {

	private final TicketRepository ticketRepository;
	private final TicketStatusHistoryRepository ticketStatusHistoryRepository;

	public TicketService(TicketRepository ticketRepository,
			TicketStatusHistoryRepository ticketStatusHistoryRepository) {

		this.ticketRepository = ticketRepository;
		this.ticketStatusHistoryRepository = ticketStatusHistoryRepository;

	}

	public Ticket createTicket(String title, String description) {
		Ticket ticket = new Ticket(title, description);
		return ticketRepository.save(ticket);
	}

	public List<Ticket> listTickets() {
		return ticketRepository.findAll();
	}

	public Ticket changeStatus(Long ticketId, TicketStatus newStatus) {

		Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket Not Found"));

		TicketStatus oldStatus = ticket.getStatus();
		
		validateTransition(oldStatus, newStatus);
		
		ticket.changeStatus(newStatus);
		ticketRepository.save(ticket);
		
		TicketStatusHistory history = new TicketStatusHistory(ticket, oldStatus, newStatus);
		ticketStatusHistoryRepository.save(history);

		return ticket;
	}

	public void validateTransition(TicketStatus oldStatus, TicketStatus newStatus) {
		if (oldStatus == TicketStatus.OPEN && newStatus == TicketStatus.IN_PROGRESS) {
			return;
		}

		if (oldStatus == TicketStatus.IN_PROGRESS && newStatus == TicketStatus.CLOSED) {
			return;
		}

		throw new IllegalStateException("Invalid status transition: " + oldStatus + " -> " + newStatus);
	}
}

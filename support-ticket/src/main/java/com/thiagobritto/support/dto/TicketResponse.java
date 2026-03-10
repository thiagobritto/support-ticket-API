package com.thiagobritto.support.dto;

import java.time.LocalDateTime;

import com.thiagobritto.support.domain.Ticket;
import com.thiagobritto.support.domain.TicketStatus;

public class TicketResponse {

	private Long id;
	private String title;
	private String description;
	private TicketStatus status;
	private LocalDateTime createdAt;

	public TicketResponse(Long id, String title, String description, TicketStatus status, LocalDateTime createdAt) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
	}

	public static TicketResponse from(Ticket ticket) {
		return new TicketResponse(
				ticket.getId(), 
				ticket.getTitle(), 
				ticket.getDescription(), 
				ticket.getStatus(),
				ticket.getCreatedAt());
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

}

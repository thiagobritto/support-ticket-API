package com.thiagobritto.support.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_status_history")
public class TicketStatusHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	private Ticket ticket;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TicketStatus oldStatus;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TicketStatus newStatus;

	@Column(nullable = false)
	private LocalDateTime changedAt;

	protected TicketStatusHistory() {

	}

	public TicketStatusHistory(Ticket ticket, TicketStatus oldStatus, TicketStatus newStatus) {
		this.ticket = ticket;
		this.oldStatus = oldStatus;
		this.newStatus = newStatus;
		this.changedAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public TicketStatus getOldStatus() {
		return oldStatus;
	}

	public TicketStatus getNewStatus() {
		return newStatus;
	}

	public LocalDateTime getChangedAt() {
		return changedAt;
	}

}

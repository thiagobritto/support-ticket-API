package com.thiagobritto.support.dto;

import java.time.LocalDateTime;

import com.thiagobritto.support.domain.TicketStatus;
import com.thiagobritto.support.domain.TicketStatusHistory;

public class TicketHistoryResponse {

	private TicketStatus oldStatus;
	private TicketStatus newStatus;
	private LocalDateTime changedAt;

	public TicketHistoryResponse(TicketStatus oldStatus, TicketStatus newStatus, LocalDateTime changedAt) {
		this.oldStatus = oldStatus;
		this.newStatus = newStatus;
		this.changedAt = changedAt;
	}
	
	public static TicketHistoryResponse from(TicketStatusHistory history) {
		
		return new TicketHistoryResponse(
				history.getOldStatus(), 
				history.getNewStatus(), 
				history.getChangedAt());
		
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

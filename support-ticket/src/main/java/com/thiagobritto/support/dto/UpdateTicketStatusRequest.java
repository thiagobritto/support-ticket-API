package com.thiagobritto.support.dto;

import com.thiagobritto.support.domain.TicketStatus;

import jakarta.validation.constraints.NotNull;

public class UpdateTicketStatusRequest {

	@NotNull
	private TicketStatus status;

	public TicketStatus getStatus() {
		return status;
	}
}

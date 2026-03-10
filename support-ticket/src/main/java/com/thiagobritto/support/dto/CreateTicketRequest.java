package com.thiagobritto.support.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateTicketRequest {

	@NotBlank
	private String title;

	@NotBlank
	private String description;

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

}

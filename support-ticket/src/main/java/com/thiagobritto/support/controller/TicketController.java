package com.thiagobritto.support.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thiagobritto.support.domain.Ticket;
import com.thiagobritto.support.dto.CreateTicketRequest;
import com.thiagobritto.support.dto.TicketHistoryResponse;
import com.thiagobritto.support.dto.TicketResponse;
import com.thiagobritto.support.dto.UpdateTicketStatusRequest;
import com.thiagobritto.support.service.TicketService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	private final TicketService service;

	public TicketController(TicketService service) {
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TicketResponse create(@RequestBody @Valid CreateTicketRequest request) {

		Ticket ticket = service.createTicket(request.getTitle(), request.getDescription());

		return TicketResponse.from(ticket);

	}

	@GetMapping
	public List<TicketResponse> list() {

		return service.listTickets().stream().map(TicketResponse::from).toList();

	}

	@PatchMapping("/{id}/status")
	public TicketResponse updateStatus(@PathVariable Long id, @RequestBody @Valid UpdateTicketStatusRequest request) {

		Ticket ticket = service.changeStatus(id, request.getStatus());
		return TicketResponse.from(ticket);

	}

	@GetMapping("/{id}/history")
	public List<TicketHistoryResponse> history(@PathVariable Long id) {

		return service.getTicketHistory(id).stream().map(TicketHistoryResponse::from).toList();

	}
}

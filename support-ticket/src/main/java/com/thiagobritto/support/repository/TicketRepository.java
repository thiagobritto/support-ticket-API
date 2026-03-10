package com.thiagobritto.support.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiagobritto.support.domain.Ticket;
import com.thiagobritto.support.domain.TicketStatus;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByStatus(TicketStatus status);

}

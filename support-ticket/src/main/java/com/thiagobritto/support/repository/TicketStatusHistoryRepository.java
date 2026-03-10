package com.thiagobritto.support.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiagobritto.support.domain.TicketStatusHistory;

public interface TicketStatusHistoryRepository  extends JpaRepository<TicketStatusHistory, Long> {

    List<TicketStatusHistory> findByTicketIdOrderByChangedAtDesc(Long ticketId);

}
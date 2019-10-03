package org.example.demo.ticket.consumer.contract.dao;

import java.util.List;

import org.example.demo.ticket.model.bean.ticket.TicketStatut;

public interface TicketStatutDao {
	List<TicketStatut> getListStatut();
}

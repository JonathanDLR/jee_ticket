package org.example.demo.ticket.business.contract.manager;

import java.util.List;

import org.example.demo.ticket.model.bean.ticket.TicketStatut;

public interface TicketStatutManager {
	/**
	 * send list of ticket statut
	 * @return
	 */
	List<TicketStatut> getListTicketStatut();
}

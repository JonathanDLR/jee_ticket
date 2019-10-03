package org.example.demo.ticket.business.contract.manager;

public interface ManagerFactory {	
	ProjetManager getProjetManager();
	
	void setProjetManager(ProjetManager pProjetManager);

	TicketManager getTicketManager();
	
	void setTicketManager(TicketManager pTicketManager);
	
	TicketStatutManager getTicketStatutManager();
	
	void setTicketStatutManager(TicketStatutManager pTicketStatutManager);
}

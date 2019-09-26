package org.example.demo.ticket.consumer.contract.dao;

public interface DaoFactory {
	ProjetDao getProjetDao();
	
	void setProjetDao(ProjetDao pProjetDao);
	
	TicketDao getTicketDao();
	
	void setTicketDao(TicketDao pTicketDao);
	
	UtilisateurDao getUtilisateurDao();
	
	void setUtilisateurDao(UtilisateurDao pUtilisateurDao);
}

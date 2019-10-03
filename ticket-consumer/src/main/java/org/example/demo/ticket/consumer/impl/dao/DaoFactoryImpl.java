package org.example.demo.ticket.consumer.impl.dao;

import org.example.demo.ticket.consumer.contract.dao.DaoFactory;
import org.example.demo.ticket.consumer.contract.dao.ProjetDao;
import org.example.demo.ticket.consumer.contract.dao.TicketDao;
import org.example.demo.ticket.consumer.contract.dao.TicketStatutDao;
import org.example.demo.ticket.consumer.contract.dao.UtilisateurDao;

public class DaoFactoryImpl implements DaoFactory {
	private ProjetDao projetDao;
	private TicketDao ticketDao;
	private TicketStatutDao ticketStatutDao;
	private UtilisateurDao utilisateurDao;

	@Override
	public ProjetDao getProjetDao() {
		return this.projetDao;
	}

	@Override
	public void setProjetDao(ProjetDao pProjetDao) {
		this.projetDao = pProjetDao;	
	}

	@Override
	public TicketDao getTicketDao() {
		return this.ticketDao;
	}

	@Override
	public void setTicketDao(TicketDao pTicketDao) {
		this.ticketDao = pTicketDao;
	}
	
	@Override
	public TicketStatutDao getTicketStatutDao() {
		return this.ticketStatutDao;
	}
	
	@Override
	public void setTicketStatutDao(TicketStatutDao pTicketStatutDao) {
		this.ticketStatutDao = pTicketStatutDao;
	}
	
	@Override
	public UtilisateurDao getUtilisateurDao() {
		return this.utilisateurDao;
	}

	@Override
	public void setUtilisateurDao(UtilisateurDao pUtilisateurDao) {
		this.utilisateurDao = pUtilisateurDao;
	}

}

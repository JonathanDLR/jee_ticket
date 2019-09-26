package org.example.demo.ticket.business.impl.manager;


import org.example.demo.ticket.business.contract.manager.ManagerFactory;
import org.example.demo.ticket.business.contract.manager.ProjetManager;
import org.example.demo.ticket.business.contract.manager.TicketManager;


public class ManagerFactoryImpl implements ManagerFactory {
	
	private ProjetManager projetManager;
	
	
	private TicketManager ticketManager;
	
	@Override
	public ProjetManager getProjetManager() {
		return this.projetManager;
	}
	
	@Override
	public void setProjetManager(ProjetManager pProjetManager) {
		projetManager = pProjetManager;
	}
	
	@Override
	public TicketManager getTicketManager() {
		return this.ticketManager;
	}
	
	@Override
	public void setTicketManager(TicketManager pTicketManager) {
		ticketManager = pTicketManager;
	}
}

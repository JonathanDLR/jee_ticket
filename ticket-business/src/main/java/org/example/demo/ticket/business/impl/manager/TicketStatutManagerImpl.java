package org.example.demo.ticket.business.impl.manager;

import java.util.List;

import org.example.demo.ticket.business.contract.manager.TicketStatutManager;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;

public class TicketStatutManagerImpl extends AbstractManager implements TicketStatutManager {
    @Override
    public List<TicketStatut> getListTicketStatut() {
    	
    	List<TicketStatut> vList = getDaoFactory().getTicketStatutDao().getListStatut();
    	
    	return vList;
    }
}

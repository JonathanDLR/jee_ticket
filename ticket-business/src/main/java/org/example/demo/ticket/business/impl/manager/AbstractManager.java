package org.example.demo.ticket.business.impl.manager;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.demo.ticket.consumer.contract.dao.DaoFactory;
import org.springframework.transaction.PlatformTransactionManager;

abstract public class AbstractManager {
	@Inject
	@Named("txManagerTicket")
	private PlatformTransactionManager platformTransactionManager;
	public PlatformTransactionManager getPlatformTransactionManager() {
		return platformTransactionManager;
	}
	private static DaoFactory daoFactory;
	
	protected static DaoFactory getDaoFactory() {
		return daoFactory;
	}
	
	public static void setDaoFactory(DaoFactory pDaoFactory) {
		daoFactory = pDaoFactory;
	}
}

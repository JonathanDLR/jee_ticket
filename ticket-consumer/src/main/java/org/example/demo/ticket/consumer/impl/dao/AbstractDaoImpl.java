package org.example.demo.ticket.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public class AbstractDaoImpl {
	@Inject
	@Named("dataSourceTicket")
	private DataSource dataSource;
	
	protected DataSource getDataSource() {
		return dataSource;
	}

	public void setDatasource(DataSource datasource) {
        this.dataSource = datasource;
    }
}
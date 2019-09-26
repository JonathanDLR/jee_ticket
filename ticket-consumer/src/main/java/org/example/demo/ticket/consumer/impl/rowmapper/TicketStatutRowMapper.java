package org.example.demo.ticket.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.springframework.jdbc.core.RowMapper;

public class TicketStatutRowMapper implements RowMapper<TicketStatut> {
	@Override
	public TicketStatut mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		TicketStatut vTicketStatut = new TicketStatut(pRS.getInt("id"));
		vTicketStatut.setLibelle(pRS.getString("libelle"));
		
		return vTicketStatut;
	}
}

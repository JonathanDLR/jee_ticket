package org.example.demo.ticket.consumer.impl.dao;

import java.util.List;

import org.example.demo.ticket.consumer.contract.dao.TicketStatutDao;
import org.example.demo.ticket.consumer.impl.rowmapper.TicketStatutRowMapper;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TicketStatutDaoImpl extends AbstractDaoImpl implements TicketStatutDao {
	@Override
	public List<TicketStatut> getListStatut() {
		String vSql = "SELECT * FROM public.statut";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<TicketStatut> vRowMapper = new TicketStatutRowMapper();
		
		List<TicketStatut> vListStatut = vJdbcTemplate.query(vSql, vRowMapper);
		
		return vListStatut;
	}
}

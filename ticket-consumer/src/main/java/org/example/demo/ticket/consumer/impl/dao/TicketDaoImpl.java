package org.example.demo.ticket.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import org.example.demo.ticket.consumer.contract.dao.TicketDao;
import org.example.demo.ticket.consumer.impl.rowmapper.TicketStatutRowMapper;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class TicketDaoImpl extends AbstractDaoImpl implements TicketDao {
	@Override
	public int getCountTicket(RechercheTicket pRechercheTicket) {
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		StringBuilder vSql = new StringBuilder("SELECT COUNT(*) FROM ticket WHERE 1=1");
		
		if (pRechercheTicket != null) {
			if (pRechercheTicket.getAuteurId() != null) {
				vSql.append(" AND auteur_id = :auteur_id");
				vParams.addValue("auteur_id", pRechercheTicket.getAuteurId());
			}
			
			if (pRechercheTicket.getProjetId() != null) {
				vSql.append(" AND projet_id = :projet_id");
				vParams.addValue("projet_id", pRechercheTicket.getProjetId());
			}
		}
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		int vNbreTicket = vJdbcTemplate.queryForObject(vSql.toString(), vParams, Integer.class);
		
		return vNbreTicket;
	}
	
	@Override
	public List<TicketStatut> getListStatut() {
		String vSql = "SELECT * FROM public.statut";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<TicketStatut> vRowMapper = new TicketStatutRowMapper();
		
		List<TicketStatut> vListStatut = vJdbcTemplate.query(vSql, vRowMapper);
		
		return vListStatut;
	}
	
	@Override
	public void updateTicketStatut(TicketStatut pTicketStatut) {
		String vSql = "UPDATE statut SET libelle = :libelle WHERE id = :id";
		
		BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pTicketStatut);
		vParams.registerSqlType("libelle", Types.VARCHAR);
		vParams.registerSqlType("id", Types.INTEGER);
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		int vNbreLignMaj = vJdbcTemplate.update(vSql, vParams);
	}

	@Override
	public void updateTicket(Ticket pTicket) {
		// TODO Auto-generated method stub
		
	}
}

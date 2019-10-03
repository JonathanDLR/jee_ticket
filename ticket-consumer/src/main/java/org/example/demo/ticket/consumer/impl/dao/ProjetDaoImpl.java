package org.example.demo.ticket.consumer.impl.dao;

import java.sql.Types;
import java.util.List;


import org.example.demo.ticket.consumer.contract.dao.ProjetDao;
import org.example.demo.ticket.consumer.impl.rowmapper.ProjetRowMapper;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.projet.Version;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class ProjetDaoImpl extends AbstractDaoImpl implements ProjetDao {
	@Override
	public List<Projet> getProjetList() {
		String vSql = "SELECT * from projet";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<Projet> vRowMapper = new ProjetRowMapper();
		
		List<Projet> vListProjet = vJdbcTemplate.query(vSql, vRowMapper);
		
		return vListProjet;
	}
	
	@Override
	public Projet getProjet(Integer pId) {
		String vSql = "SELECT * FROM projet WHERE id = :id";
		
		BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pId);
		vParams.registerSqlType("id", Types.INTEGER);
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		Projet vProjet = vJdbcTemplate.queryForObject(vSql, vParams, Projet.class);
		
		return vProjet;
	}

	@Override
	public void updateVersion(Version pVersion) {
		String vSql = "UPDATE projet SET version = :version WHERE id = :id";
		
	    MapSqlParameterSource vParams = new MapSqlParameterSource();
	    vParams.addValue("version", pVersion);
	    vParams.addValue("id", pVersion.getProjet().getId());

	    NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

	    vJdbcTemplate.update(vSql, vParams);
	}
}

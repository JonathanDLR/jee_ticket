package org.example.demo.ticket.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import org.example.demo.ticket.consumer.contract.dao.UtilisateurDao;
import org.example.demo.ticket.consumer.impl.rowmapper.UtilisateurRowMapper;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {
	@Override
	public List<Utilisateur> getListUtilisateur() {
		String vSql = "SELECT * FROM utilisateur";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		RowMapper<Utilisateur> vRowMapper = new UtilisateurRowMapper();
		
		List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSql, vRowMapper);
		
		return vListUtilisateur;
	}
	
	@Override
	public Utilisateur getUtilisateur(Integer pId) {
		String vSql = "SELECT * FROM utilisateur WHERE id = :id";
		
		BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pId);
		vParams.registerSqlType("id", Types.INTEGER);
		
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		Utilisateur vUtilisateur = vJdbcTemplate.queryForObject(vSql, vParams, Utilisateur.class);
		
		return vUtilisateur;
	}
}

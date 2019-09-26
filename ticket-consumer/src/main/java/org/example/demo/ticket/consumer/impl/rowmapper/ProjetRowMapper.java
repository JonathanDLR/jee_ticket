package org.example.demo.ticket.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.demo.ticket.model.bean.projet.Projet;
import org.springframework.jdbc.core.RowMapper;

public class ProjetRowMapper implements RowMapper<Projet> {
	@Override
	public Projet mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Projet vProjet = new Projet(pRS.getInt("id"));
		vProjet.setNom(pRS.getString("nom"));
		vProjet.setDateCreation(pRS.getDate("date_creation"));
		vProjet.setCloture(pRS.getBoolean("cloture"));
		
		return vProjet;
	}
}

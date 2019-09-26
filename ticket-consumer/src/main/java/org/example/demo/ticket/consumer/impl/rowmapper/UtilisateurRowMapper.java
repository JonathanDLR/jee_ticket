package org.example.demo.ticket.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

public class UtilisateurRowMapper implements RowMapper<Utilisateur> {
	@Override
	public Utilisateur mapRow(ResultSet pRS, int pRowNum) throws SQLException {
		Utilisateur vUtilisateur = new Utilisateur();
		vUtilisateur.setId(pRS.getInt("id"));
		vUtilisateur.setNom(pRS.getString("nom"));
		vUtilisateur.setPrenom(pRS.getString("prenom"));
		
		return vUtilisateur;
	}
}

package org.example.demo.ticket.consumer.contract.dao;

import java.util.List;

import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;

public interface UtilisateurDao {

	List<Utilisateur> getListUtilisateur();

	Utilisateur getUtilisateur(Integer pId);


}

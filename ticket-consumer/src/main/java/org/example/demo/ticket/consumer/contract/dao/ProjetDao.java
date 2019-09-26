package org.example.demo.ticket.consumer.contract.dao;

import java.util.List;

import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.projet.Version;

public interface ProjetDao {
	List<Projet> getProjetList();

	Projet getProjet(Integer pId);

	void updateVersion(Version pVersion);
}

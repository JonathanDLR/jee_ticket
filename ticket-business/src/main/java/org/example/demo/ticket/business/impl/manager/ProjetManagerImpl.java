package org.example.demo.ticket.business.impl.manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.demo.ticket.business.contract.manager.ProjetManager;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.projet.Version;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


public class ProjetManagerImpl extends AbstractManager implements ProjetManager {
	@Inject
	@Named("txManagerProjet")
	private PlatformTransactionManager platformTransactionManager;
	/**
     * Renvoie le projet demandé
     *
     * @param pId l'identifiant du projet
     * @return Le {@link Projet}
     * @throws NotFoundException Si le projet n'est pas trouvé
     */
    @Override
	public Projet getProjet(Integer pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Projet non trouvé : ID=" + pId);
        } else {
        	Projet vProjet = getDaoFactory().getProjetDao().getProjet(pId);
        	Utilisateur vUtilisateur = getDaoFactory().getUtilisateurDao().getUtilisateur(vProjet.getId());
        	vProjet.setResponsable(vUtilisateur);
        	return vProjet;
        }
    }


    /**
     * Renvoie la liste des {@link Projet}
     *
     * @return List
     */
    @Override
	public List<Projet> getListProjet() {
    	List<Projet> vListDao = getDaoFactory().getProjetDao().getProjetList();
        List<Projet> vList = new ArrayList<>();
        for (Projet vProjet: vListDao) {
            Utilisateur vUtilisateur = getDaoFactory().getUtilisateurDao().getUtilisateur(vProjet.getId());
            vProjet.setResponsable(vUtilisateur);
            vList.add(vProjet);
        }
        return vList;
    }
    
    @Override
    public void insertVersion(Version pVersion) {
    	if (pVersion != null) {
    		if (pVersion.getNumero() instanceof String) {
    			TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
    			vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
    				@Override
    				protected void doInTransactionWithoutResult(TransactionStatus pTransactionStatus) {
    					getDaoFactory().getProjetDao().updateVersion(pVersion);
    				}
    			});
    		}
    		
    	}
    	
    	
    }
}

package org.example.demo.ticket.batch;


import java.io.PrintWriter;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.business.contract.manager.ManagerFactory;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.example.demo.ticket.model.exception.TechnicalException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


/**
 * Classe Principale de lancement des Batches.
 *
 * @author lgu
 */
@Component
public class Main {

    /** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(Main.class);


    /**
     * The entry point of application.
     *
     * @param pArgs the input arguments
     * @throws TechnicalException sur erreur technique
     */
    @SuppressWarnings("resource")
	public static void main(String[] pArgs) throws TechnicalException {
    	ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");
    	// Properties exportTicketPath = (Properties) vApplicationContext.getBean("exportTicketPath");
    	//String path = exportTicketPath.getProperty("path");
    	String path ="${config.exportpath}";
        ManagerFactory vManagerFactory = vApplicationContext.getBean("managerFactory", ManagerFactory.class);
    	
    	try {
            if (pArgs.length < 1) {
                throw new TechnicalException("Veuillez préciser le traitement à effectuer !");
            }

            String vTraitementId = pArgs[0];
            if ("ExportTicketStatus".equals(vTraitementId)) {
                LOGGER.info("Execution du traitement : ExportTicketStatus");
                // ...
                List<TicketStatut> vList = vManagerFactory.getTicketManager().getListTicketStatus();
                PrintWriter writer = new PrintWriter(path.concat("/ticket-statut.txt"));
                for (TicketStatut ticketStatut: vList) {
                	writer.println(ticketStatut.toString());
                }
                writer.flush();
            } else {
                throw new TechnicalException("Traitement inconnu : " + vTraitementId);
            }
        } catch (Throwable vThrowable) {
            LOGGER.error(vThrowable);
            System.exit(1);
        }
    }
}

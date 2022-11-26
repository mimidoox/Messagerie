package ma.projet.test;

import java.util.Date;

import ma.projet.beans.Employe;
import ma.projet.beans.Message;
import ma.projet.service.EmployeService;
import ma.projet.service.MessageService;

public class Messagerie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeService es = new EmployeService();
		//Création des employes
		//es.create(new Employe("LACHGAR", "Mohamed"));
		//es.create(new Employe("RAMI", "ALI"));
		//es.create(new Employe("SAFI", "Fatima"));
		//es.create(new Employe("ARRAJ", "Mohamed"));
		//Modification d'un employe
	/*	Employe e = es.getById(3);
		if (e != null) {
		 e.setNom("ALAOUI");
		 e.setPrenom("Manale");
		 es.update(e);
		}*/
		

		//Suppression d'un employe
		//es.delete(es.getById(2));

		//Liste des employes
		
		for(Employe emp : es.getAll()) {
		 System.out.println(""+emp.getNom());
	}
		MessageService ms = new MessageService();
		
		/*
		 * ms.create(new Message("Réunion", "Réunion de fin d'année", new
		 * Date("2022/11/26"), es.getById(1), es.getById(4))); ms.create(new
		 * Message("Réunion", "Réunion de fin d'année", new Date("2022/11/25"),
		 * es.getById(1), es.getById(3))); ms.create(new Message("Stage",
		 * "Stage à Marrakech", new Date("2022/11/26"), es.getById(4), es.getById(1)));
		 * ms.create(new Message("Stage", "Stage à Marrakech", new Date("2022/11/26"),
		 * es.getById(4), es.getById(3)));
		 */
		//Les message reçus par l'employé 3
		for (Message m : ms.getAll()) {
		 if(m.getEmpRecepteur().getId() == 3)
		 System.out.println(""+m.getSujet());
	}
		
		
		
		
	}
	

}

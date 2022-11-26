package ma.projet.test;

import ma.projet.beans.Employe;
import ma.projet.service.EmployeService;

public class TestEmploye {

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
		//System.out.println(es.getAll());
	}

}

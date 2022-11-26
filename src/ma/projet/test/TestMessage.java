package ma.projet.test;

import java.util.Date;

import ma.projet.beans.Message;
import ma.projet.service.EmployeService;
import ma.projet.service.MessageService;

public class TestMessage {
	public static void main(String[] args) {
		EmployeService es = new EmployeService();
		MessageService ms = new MessageService();
		
		ms.create(new Message("Réunion", "Réunion de fin d'année", new Date("2022/11/26"), es.getById(1), es.getById(4)));
		ms.create(new Message("Réunion", "Réunion de fin d'année", new Date("2022/11/25"), es.getById(1), es.getById(3)));
		ms.create(new Message("Stage", "Stage à Marrakech", new Date("2022/11/26"), es.getById(4), es.getById(1)));
		ms.create(new Message("Stage", "Stage à Marrakech", new Date("2022/11/26"), es.getById(4), es.getById(3)));
		//Les message reçus par l'employé 3
	/*	for (Message m : ms.getAll()) {
		 if(m.getEmpRecepteur().getId() == 3)
		 System.out.println(""+m.getSujet());
	}*/
}
}

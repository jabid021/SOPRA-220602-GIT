package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.joined.Chien;
import model.joined.Lion;
import model.single.Admin;
import model.single.User;
import model.table.Avion;
import model.table.Voiture;

public class TestJPA {

	public static void main(String[] args) {
		
		
		
		Lion lion = new Lion("Orange");
		Chien chien = new Chien("Bichon");
		
		User user=new User("log", "pass", "Jordan");
		Admin adm = new Admin("admin","admin123");
		
		
		Avion avion = new Avion(2,"essence","Air France");
		Voiture voiture = new Voiture(4,"Smart");
		
		
		
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
		
		EntityManager em = emf.createEntityManager();
		
		
		
		em.getTransaction().begin();
		
		em.persist(user);
		em.persist(adm);
		
		
		em.getTransaction().commit();
		
		
		em.close();
		
		emf.close();
		

	}

}

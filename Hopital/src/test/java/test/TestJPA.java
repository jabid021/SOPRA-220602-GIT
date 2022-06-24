package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Medecin;
import model.Patient;
import model.Visite;

public class TestJPA {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
		
		Patient p = new Patient(7777,"Abid","Jordan");
		Medecin m = new Medecin("med1");
		m.setSalle(1);
		
		
		
		Visite v = new Visite(m,p);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
			em.persist(p);
			
			em.persist(v);
		
		em.getTransaction().commit();
		
		
	
		
		emf.close();
		

	}

}

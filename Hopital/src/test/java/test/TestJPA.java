package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Civilite;
import model.Medecin;
import model.Patient;
import model.Secretaire;
import model.Visite;

public class TestJPA {

	public static void main(String[] args) {
		
		
		//1-1 => OneToOne
		//1-* => OneToMany
		//*-  1 => ManyToOne
		// * - * => ManyToMany
		
		Patient p = new Patient(7777,"Abid","Jordan",Civilite.Homme);
		
		Patient p2 = new Patient(7778,"Abid","Jeremy",Civilite.NB);
		
		
		Medecin m = new Medecin("med1","med1");
		
		m.setSalle(1);
		Visite v = new Visite(m,p);
		
		
		Medecin m2 = new Medecin("med2","med2");
		
		Secretaire s = new Secretaire("sec","sec");
		
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
		
		EntityManager em = emf.createEntityManager();
		
		
		
		em.getTransaction().begin();
		
		
		//persist => insert en bdd
			em.persist(p);
			em.persist(p2);
			
			em.persist(m);
			em.persist(m2);
			em.persist(s);
			
			em.persist(v);
		
		em.getTransaction().commit();
		
		
		em.close();
		
		
		em = emf.createEntityManager();
		
		System.out.println(em.find(Patient.class, 7777).getCiv());
		
		em.close();
		
		emf.close();
		

	}

}

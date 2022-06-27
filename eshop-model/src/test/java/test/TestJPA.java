package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adresse;
import model.Client;
import model.Fournisseur;
import model.Personne;

public class TestJPA {

	public static void main(String[] args) {
		
		Adresse a1 = new Adresse("6","rue rougemont","Paris","75009");
		Adresse a2 = new Adresse("23","rue de paris","Paris","75015");
		
		Personne p = new Client("Jordan","Abid",a2,29,LocalDate.parse("1993-05-01"));
		
		Personne p2 = new Fournisseur("Charly","Abid",a1,"AJC");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopBDD");
		
		EntityManager em = emf.createEntityManager();
		
		
		
		em.getTransaction().begin();
		
		
		//persist => insert en bdd
			em.persist(p);
			em.persist(p2);
		
		em.getTransaction().commit();
		
		
		em.close();
		
		emf.close();
		

	}

}

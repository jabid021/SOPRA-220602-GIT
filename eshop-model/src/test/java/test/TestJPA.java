package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adresse;
import model.Client;
import model.Fournisseur;
import model.Personne;
import model.Produit;

public class TestJPA {

	public static void main(String[] args) {
		
		Adresse a1 = new Adresse("6","rue rougemont","Paris","75009");
		Adresse a2 = new Adresse("23","rue de paris","Paris","75015");
		
		Client c = new Client("Jordan","Abid",a2,29,LocalDate.parse("1993-05-01"));
		
		Fournisseur f = new Fournisseur("Charly","Abid",a1,"AJC");
		
		
		Produit p1 =new Produit("Formation Java",800.589,f);
		Produit p2 =new Produit("Formation SQL",500.584,f);
		
		c.getAchats().add(p1);
		c.getAchats().add(p2);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopBDD");
		
		EntityManager em = emf.createEntityManager();
		
		
		
		em.getTransaction().begin();
		
		
		//persist => insert en bdd
			em.persist(f);
			em.persist(p1);
			em.persist(p2);
			
			
			em.persist(c);
		
		em.getTransaction().commit();
		
		
		em.close();
		
		emf.close();
		

	}

}

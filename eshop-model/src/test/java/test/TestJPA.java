package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Achat;
import model.Adresse;
import model.Client;
import model.Fournisseur;
import model.Produit;

public class TestJPA {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopBDD");
	
	public static void initData() 
	{
		
		
		Adresse a1 = new Adresse("6","rue rougemont","Paris","75009");
		Adresse a2 = new Adresse("23","rue de paris","Paris","75015");
		
		Client c = new Client("Jordan","Abid",a2,29,LocalDate.parse("1993-05-01"));
		
		Fournisseur f = new Fournisseur("Charly","Abid",a1,"AJC");
		
		
		Produit p1 =new Produit("Formation Java",800.589,f);
		Produit p2 =new Produit("Formation SQL",500.584,f);
		
		
		Achat achat = new Achat(1,p1,c);

		Achat achat2 = new Achat(3,p2,c);
		
		
		
		
		EntityManager em = emf.createEntityManager();
		
		
		
		em.getTransaction().begin();
		
		
		//persist => insert en bdd
			em.persist(f);
			em.persist(p1);
			em.persist(p2);
			
			
			em.persist(c);
			
			em.persist(achat);
			em.persist(achat2);
		
		em.getTransaction().commit();
		
		
		em.close();
		
	
		
	}
	
	public static void main(String[] args) {
		
		//initData();
		/*
		 *                C=> insert - em.persist(p); => p est managed
		 * R => findById / findAll - em.find() return un objet managed/ em.createQuery();
		 * U => update => em.merge();
		 * D => delete => em.remove();
		 * 
		 * 
		 * em.find(x.Class,id) => retourne un objet x qui est managed
		 * em.persist(x) => x est managed
		 * em.remove(x) => x doit etre managed avant le remove
		 * copieX=em.merge(x) => x n'est pas managed, copieX est managed
		 * 
		 * 
		 * Produit p = new Produit();
		 * 
		 *p=em.merge(p);
		 * 
		 * 
		 * 
		 * Achat a = new Achat(p)
		 * em.persist(a)
		 * 
		 */
		
	
		
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		Achat a = em.find(Achat.class, 1);
		
		Fournisseur f = em.find(Fournisseur.class, 1);
		Produit p = new Produit("Formation UML",700.59,f);
		p.setId(3);
		
		
		
		em.merge(p);
		
		em.remove(p);
		
		em.getTransaction().commit();
		
		em.close();
		
	
		
		//System.out.println(p.getVentes());
	
		
		
		
		
		
		
		emf.close();
	}

}

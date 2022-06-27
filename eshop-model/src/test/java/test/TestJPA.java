package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Personne;

public class TestJPA {

	public static void main(String[] args) {
		
		
		Personne p = new Personne("Jordan","Abid");
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopBDD");
		
		EntityManager em = emf.createEntityManager();
		
		
		
		em.getTransaction().begin();
		
		
		//persist => insert en bdd
			em.persist(p);
		
		em.getTransaction().commit();
		
		
		em.close();
		
		emf.close();
		

	}

}

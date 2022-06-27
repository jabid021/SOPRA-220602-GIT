package test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.joined.Animal;
import model.joined.Chien;
import model.joined.Lion;
import model.single.Admin;
import model.single.Compte;
import model.single.ConfigPc;
import model.single.User;
import model.table.Avion;
import model.table.Vehicule;
import model.table.Voiture;

public class TestJPA {

	public static void main(String[] args) {
		
		
		
		Lion lion = new Lion("Orange");
		Chien chien = new Chien("Bichon");
		ConfigPc config = new ConfigPc(8,"Dell");
		
		
		User user=new User("log", "pass", "Jordan",LocalDate.parse("1993-05-01"),config);
		
		Admin adm = new Admin("admin","admin123");
		
		
		Avion avion = new Avion(2,"essence","Air France");
		Voiture voiture = new Voiture(4,"Smart");
		
		
		
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
		
		EntityManager em = emf.createEntityManager();
		
		
		
		em.getTransaction().begin();
		
		em.persist(user);
		em.persist(adm);
		em.persist(lion);
		em.persist(chien);
		em.persist(avion);
		em.persist(voiture);
		
		em.getTransaction().commit();
		
		
		em.close();
		
		
		
		
		em = emf.createEntityManager();
		
		
		//List<Compte> comptes= em.createQuery("from User").getResultList();
		//List<Animal> zoo=em.createQuery("from Animal").getResultList();
		List<Vehicule> garage=em.createQuery("from Voiture").getResultList();;
		
		
		System.out.println(garage);
		
		
		em.close();
		
		
		emf.close();
		

	}

}

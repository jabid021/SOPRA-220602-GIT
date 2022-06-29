package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Contribution;
import model.Event;
import model.Message;
import model.Participation;
import util.Context;

public class TestLazy {

	//Acces aux messages AVANT le em.close ❌
	//Impossible de faire des filtres sur les messages ❌
	public static List<Event> showLazy() 
	{
		EntityManager em  = Context.getInstance().getEmf().createEntityManager();


		Query q = em.createQuery("from Event");
		List<Event> events = q.getResultList();

		em.close();

		return events;

	}


	//On peut faire des filtres sur les messages ✔
	//Acces aux messages AVANT le em.close ❌
	//Uniquement les events avec au moins 1 message ❌ 
	//Retourne des doublons si l'event a plusieurs messages sans la lettre g ❌
	public static List<Event> showJoin() 
	{
		EntityManager em  = Context.getInstance().getEmf().createEntityManager();


		Query q = em.createQuery("SELECT e from Event e join e.messages ");
		List<Event> events = q.getResultList();

		em.close();

		return events;

	}


	//On peut faire des filtres sur les messages ✔
	//Acces aux messages AVANT le em.close ❌
	//Tous les events meme si 0 message ✔
	//Retourne des doublons si l'event a plusieurs messages sans la lettre g ❌
	public static List<Event> showLeftJoin() 
	{
		EntityManager em  = Context.getInstance().getEmf().createEntityManager();


		Query q = em.createQuery("SELECT e from Event e left join e.messages ");
		List<Event> events = q.getResultList();

		em.close();

		return events;

	}


	//On peut faire des filtres sur les messages ✔
	//Uniquement les events qui ont respecté le where  ✔
	//Acces aux messages AVANT le em.close ❌
	//Uniquement les events avec au moins 1 message ❌ 
	//Retourne des doublons si l'event a plusieurs messages sans la lettre g ❌
	public static List<Event> showJoinWhere() 
	{
		EntityManager em  = Context.getInstance().getEmf().createEntityManager();


		//Query q = em.createQuery("SELECT e from Event e join e.messages m group by m.event HAVING COUNT(*) >=2 ");
		Query q = em.createQuery("SELECT e from Event e join e.messages m where m.content not like '%g%' ");
		List<Event> events = q.getResultList();

		em.close();

		return events;

	}



	//On peut faire des filtres sur les messages ✔
	//Acces aux messages AVANT le em.close ❌
	//Tous les events meme si 0 message ✔
	//Retourne des doublons si l'event a plusieurs messages sans la lettre g ✔
	public static List<Event> showLeftJoinNoDoublons() 
	{
		EntityManager em  = Context.getInstance().getEmf().createEntityManager();


		Query q = em.createQuery("SELECT distinct e from Event e left join e.messages ");
		List<Event> events = q.getResultList();

		em.close();

		return events;

	}

	//On peut faire des filtres sur les messages ✔
	//Acces aux messages APRES le em.close ✔
	//Tous les events meme si 0 message ✔
	//Retourne des doublons si l'event a plusieurs messages sans la lettre g ✔
	public static List<Event> showLeftJoinFetchNoDoublons() 
	{
		EntityManager em  = Context.getInstance().getEmf().createEntityManager();

		Query q = em.createQuery("SELECT distinct e from Event e left join fetch e.messages ");
		List<Event> events = q.getResultList();

		em.close();

		return events;

	}


	//On peut faire des filtres sur les messages ✔
	//Acces aux messages APRES le em.close ✔
	//Tous les events meme si 0 message ✔
	//Retourne des doublons si l'event a plusieurs messages sans la lettre g ✔
	//Peut on recup les events avec plusieurs listes  ❌
	public static List<Event> showLeftJoinFetchNoDoublonsMessagesPlusContributionsNOTWorking() 
	{
		EntityManager em  = Context.getInstance().getEmf().createEntityManager();


		Query q = em.createQuery("SELECT distinct e from Event e left join fetch e.messages left join fetch e.demandes");
		List<Event> events = q.getResultList();

		em.close();

		return events;

	}


	//On peut faire des filtres sur les messages ✔
	//Acces aux messages APRES le em.close ✔
	//Tous les events meme si 0 message ✔
	//Retourne des doublons si l'event a plusieurs messages sans la lettre g ✔
	//Peut on recup les events avec plusieurs listes  ✔
	public static List<Event> showLeftJoinFetchNoDoublonsMessagesPlusContributionsWorking() 
	{
		EntityManager em  = Context.getInstance().getEmf().createEntityManager();


		Query q = em.createQuery("SELECT distinct e from Event e left join fetch e.messages ");
		List<Event> events = q.getResultList();
		
		q = em.createQuery("SELECT distinct e from Event e left join fetch e.demandes");
		events = q.getResultList();
		
		q = em.createQuery("SELECT distinct e from Event e left join fetch e.participants");
		events = q.getResultList();

		em.close();

		return events;

	}
	
	
	public static void demoVersion() 
	{
	
	
		Message m = Context.getInstance().getDaoMessage().findById(1);
		
		System.out.println(m);
		m.setContent("Nouveau content");
		int saisieBidon = App.saisieInt("Attente bdd");
		
		Context.getInstance().getDaoMessage().save(m);

	


	}


	public static void main(String[] args) {

		
		demoVersion();

		/*List<Event> events= showLeftJoinFetchNoDoublonsMessagesPlusContributionsWorking();

		for(Event e : events) 
		{
			System.out.println(e.getTitre());
			System.out.println("Createur : "+e.getCreateur().getPrenom());
			
			System.out.println("Liste des messages :");
			for(Message m  : e.getMessages()) 
			{
				System.out.println(m);
			}

			System.out.println("Liste des contributions :");
			for(Contribution c : e.getDemandes()) 
			{
				System.out.println(c);
			}
			
			System.out.println("Liste des participants :");
			for(Participation p : e.getParticipants()) 
			{
				System.out.println(p);
			}
			
			System.out.println("\n\n\n");
		}

		
*/
		
		

		Context.getInstance().closeEmf();

	}




}

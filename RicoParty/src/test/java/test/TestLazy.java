package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Event;
import model.Message;
import util.Context;

public class TestLazy {

	//Acces aux messages AVANT le em.close
	//Impossible de faire des filtres sur les messages
	public static List<Event> showLazy() 
	{
		EntityManager em  = Context.getInstance().getEmf().createEntityManager();

		
		Query q = em.createQuery("from Event");
		List<Event> events = q.getResultList();
		
		em.close();

		return events;

	}

	
	
		//Acces aux messages AVANT le em.close
		//On peut faire des filtres sur les messages
		//Uniquement les events qui ont respecté le where
		//Retourne des doublons si l'event à plusieurs messages en m
		public static List<Event> showJoin() 
		{
			EntityManager em  = Context.getInstance().getEmf().createEntityManager();

			
			//Query q = em.createQuery("SELECT e from Event e join e.messages m group by m.event HAVING COUNT(*) >=2 ");
			Query q = em.createQuery("SELECT e from Event e join e.messages m where m.content not like '%g%' ");
			List<Event> events = q.getResultList();
			
			em.close();

			return events;

		}


	public static void main(String[] args) {


		List<Event> events= showJoin();
		
		for(Event e : events) 
		{
			System.out.println(e.getTitre());
			System.out.println("Createur : "+e.getCreateur().getPrenom());
			/*for(Message m  : e.getMessages()) 
			{
				System.out.println(m);
			}*/
		}

		Context.getInstance().closeEmf();




	}




}

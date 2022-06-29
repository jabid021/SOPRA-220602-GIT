package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Event;
import util.Context;

public class DAOEvent implements IDAO<Event,Integer> {

	@Override
	public Event findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Event e = em.find(Event.class, id);
		em.close();
		return e;
	}

	@Override
	public List<Event> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		List<Event> events = em.createQuery("from Event").getResultList();
		em.close();
		return events;
	}


	@Override
	public Event save(Event e) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		e=em.merge(e);
		em.getTransaction().commit();
		em.close();
		return e;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Event e = em.find(Event.class, id);
		em.getTransaction().begin();		
		em.remove(e);
		em.getTransaction().commit();
		em.close();
	}

	
	public List<Event> findAllWithMessagesAndDemandesAndParticipants()
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


}

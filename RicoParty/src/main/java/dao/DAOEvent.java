package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Event;
import model.Message;
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



}

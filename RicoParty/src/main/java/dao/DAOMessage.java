package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Event;
import model.Message;
import model.Participation;
import util.Context;

public class DAOMessage implements IDAO<Message,Integer> {

	@Override
	public Message findById(Integer id) {

		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Message m = em.find(Message.class, id);

		em.close();
		return m;
	}

	@Override
	public List<Message> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		List<Message> messages = em.createQuery("from message").getResultList();

		em.close();
		return messages;
	}

	




	@Override
	public Message save(Message m) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();

		m=em.merge(m);

		em.getTransaction().commit();

		em.close();
		return m;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();

		Message m = em.find(Message.class, id);
		
		em.remove(m);

		em.getTransaction().commit();

		em.close();

	}
	
	public List<Message> findAllByIdEvent(int idEvent) {

		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		List<Message> messages = em.createQuery("Select m from Message m where m.event.id=:idE").setParameter("idE",idEvent).getResultList();

		em.close();
		return messages;
	}
	

}

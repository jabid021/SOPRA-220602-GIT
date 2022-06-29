package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Participation;
import util.Context;

public class DAOParticipation implements IDAOParticipation {

	@Override
	public Participation findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Participation p = em.find(Participation.class, id);

		em.close();
		return p;
	
	}

	@Override
	public List<Participation> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		List<Participation> participation = em.createQuery("from Participation").getResultList();

		em.close();
		return participation;
		
	}



	@Override
	public Participation save(Participation p) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();

		p=em.merge(p);

		em.getTransaction().commit();

		em.close();
		return p;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Participation p = em.find(Participation.class, id);
		em.getTransaction().begin();

		
		em.remove(p);

		em.getTransaction().commit();

		em.close();
		
	}

	public List<Participation> findAllByIdEvent(int idEvent) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		List<Participation> participations = em.createQuery("Select p from Participation p where p.event.id=:idP").setParameter("idP",idEvent).getResultList();

		em.close();
		return participations;
	}

	

}

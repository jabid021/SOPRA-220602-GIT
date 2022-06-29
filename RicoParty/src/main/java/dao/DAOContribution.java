package dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Contribution;
import util.Context;

public class DAOContribution  implements IDAOContribution{

	@Override
	public Contribution findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Contribution c = em.find(Contribution.class, id);
		em.close();
		return c;
	}

	@Override
	public List<Contribution> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		List<Contribution> contributions = em.createQuery("from Contribution").getResultList();
		em.close();
		return contributions;
	
	}


	@Override
	public Contribution save(Contribution c) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		c=em.merge(c);
		em.getTransaction().commit();
		em.close();
		return c;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Contribution c = em.find(Contribution.class, id);
		em.getTransaction().begin();		
		em.remove(c);
		em.getTransaction().commit();
		em.close();
		
	}

}

package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOVisite;
import model.Visite;
import util.Context;

public class DAOVisite implements IDAOVisite{

	@Override
	public Visite findById(Integer id) {

		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.close();
		return p;
	}

	@Override
	public List<Visite> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		List<Visite> visites = em.createQuery("from Visite").getResultList();

		em.close();
		return visites;
	}

	@Override
	public Visite insert(Visite p) {
		return update(p);
	}

	@Override
	public Visite update(Visite v) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();

		v=em.merge(v);

		em.getTransaction().commit();

		em.close();
		return v;
	}

	@Override
	public void delete(Visite v) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();

		v=em.merge(v);
		
		em.remove(v);

		em.getTransaction().commit();

		em.close();

	}

	@Override
	public List<Visite> findAllByIdPatient(int idPatient) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		List<Visite> visites = em.createQuery("Select v from Visite v where v.patient.id=:idP").setParameter("idP",idPatient).getResultList();

		em.close();
		return visites;
	}


}

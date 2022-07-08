package formation.hopital.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import formation.hopital.Context;
import formation.hopital.dao.IDAOMedecin;
import formation.hopital.model.Compte;
import formation.hopital.model.Medecin;

public class DAOMedecin implements IDAOMedecin {

	@Override
	public Medecin findById(Integer id) {

		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Medecin obj = em.find(Medecin.class, id);

		em.close();
		return obj;
	}

	@Override
	public List<Medecin> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		List<Medecin> medecins = em.createQuery("from Medecin").getResultList();

		em.close();
		return medecins;
	}

	@Override
	public Medecin insert(Medecin medecin) {
		return update(medecin);
	}

	@Override
	public Medecin update(Medecin medecin) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();

		medecin = em.merge(medecin);

		em.getTransaction().commit();

		em.close();
		return medecin;
	}

	@Override
	public void delete(Medecin medecin) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();

		medecin = em.merge(medecin);

		em.remove(medecin);

		em.getTransaction().commit();

		em.close();

	}
}

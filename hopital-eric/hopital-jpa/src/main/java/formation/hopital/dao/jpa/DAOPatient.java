package formation.hopital.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import formation.hopital.Context;
import formation.hopital.dao.IDAOPatient;
import formation.hopital.model.Patient;

public class DAOPatient implements IDAOPatient{

	@Override
	public Patient findById(Integer id) {

		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Patient p = em.find(Patient.class, id);

		em.close();
		return p;
	}

	@Override
	public List<Patient> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		List<Patient> patients = em.createQuery("from Patient").getResultList();

		em.close();
		return patients;
	}

	@Override
	public Patient insert(Patient p) {
		return update(p);
	}

	@Override
	public Patient update(Patient p) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();

		p=em.merge(p);

		em.getTransaction().commit();

		em.close();
		return p;
	}

	@Override
	public void delete(Patient p) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();

		p=em.merge(p);
		//p=em.find(Patient.class, p.getId());

		em.remove(p);

		em.getTransaction().commit();

		em.close();

	}


}

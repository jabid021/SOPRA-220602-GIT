package formation.hopital.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import formation.hopital.Context;
import formation.hopital.dao.IDAOCompte;
import formation.hopital.model.Compte;

public class DAOCompte implements IDAOCompte{

	@Override
	public Compte findById(Integer id) {

		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Compte p = em.find(Compte.class, id);

		em.close();
		return p;
	}

	@Override
	public List<Compte> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		List<Compte> comptes = em.createQuery("from Compte").getResultList();

		em.close();
		return comptes;
	}

	@Override
	public Compte insert(Compte c) {
		return update(c);
	}

	@Override
	public Compte update(Compte c) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();

		c=em.merge(c);

		em.getTransaction().commit();

		em.close();
		return c;
	}

	@Override
	public void delete(Compte c) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();

		c=em.merge(c);

		em.remove(c);

		em.getTransaction().commit();

		em.close();

	}

	@Override
	public Compte connect(String login, String password) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Query requete = em.createQuery("SELECT c from Compte c where c.login=:log and c.password=:pass");
		requete.setParameter("log", login);
		requete.setParameter("pass", password);
		Compte connected=null;
		try {
		connected = (Compte) requete.getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();}
		//connected=(Compte) em.createQuery("SELECT c from Compte c where c.login=:log and c.password=:pass").setParameter("log", login).setParameter("pass", password).getSingleResult();
		
		em.close();
		return connected;
	}


}

package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Compte;
import util.Context;

public class DAOCompte implements IDAO<Compte,Integer> {


	
	@Override
	public Compte findById(Integer id) {

		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Compte c = em.find(Compte.class, id);

		em.close();
		return c;
	}

	@Override
	public List<Compte> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		List<Compte> comptes = em.createQuery("from Compte").getResultList();

		em.close();
		return comptes;
	}

	

	@Override
	public Compte save(Compte c) {
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

		em.getTransaction().begin();

		Compte c = em.find(Compte.class, id);
		
		em.remove(c);

		em.getTransaction().commit();

		em.close();

	}

	
	public Compte connect(String mail, String password) {
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Query requete = em.createQuery("SELECT c from Compte c where c.login=:log and c.password=:pass");
		requete.setParameter("log", mail);
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

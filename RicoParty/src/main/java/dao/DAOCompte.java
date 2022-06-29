package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Compte;
import model.Message;
import util.Context;

public class DAOCompte implements IDAOCompte {

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
	public Compte insert(Compte c) {
		// TODO Auto-generated method stub
		return null;
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
		Compte c = em.find(Compte.class, id);
		em.getTransaction().begin();		
		em.remove(c);
		em.getTransaction().commit();
		em.close();
		
	}

	public Compte seConnecter(String mail, String password) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query requete = em.createQuery("SELECT c from Compte c where c.mail=:mail and c.password=:pass");
		requete.setParameter("mail", mail);
		requete.setParameter("pass", password);
		Compte connected=null;
		try {
		connected = (Compte) requete.getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();}
		em.close();
		return connected;
	}

}

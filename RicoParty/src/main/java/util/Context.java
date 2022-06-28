package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOCompte;
import dao.DAOEvent;
import dao.DAOMessage;
import dao.DAOParticipation;
import model.Compte;

public class Context {
	

	private Compte connected;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eric-party");
	private DAOCompte daoCompte = new DAOCompte();
	private DAOEvent daoEvent = new DAOEvent();
	private DAOMessage daoMessage = new DAOMessage();
	private DAOParticipation daoParticipation = new DAOParticipation();
	
	private static Context _instance;
	
	
	private Context() {}


	public static Context getInstance() {
		
		if(_instance==null) 
		{
			_instance=new Context();
		}
		return _instance;
		
		
	}



	public Compte getConnected() {
		return connected;
	}


	public void setConnected(Compte connected) {
		this.connected = connected;
	}




	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}


	public DAOCompte getDaoCompte() {
		return daoCompte;
	}


	public void setDaoCompte(DAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}


	public DAOEvent getDaoEvent() {
		return daoEvent;
	}


	public void setDaoEvent(DAOEvent daoEvent) {
		this.daoEvent = daoEvent;
	}


	public DAOMessage getDaoMessage() {
		return daoMessage;
	}


	public void setDaoMessage(DAOMessage daoMessage) {
		this.daoMessage = daoMessage;
	}


	public DAOParticipation getDaoParticipation() {
		return daoParticipation;
	}


	public void setDaoParticipation(DAOParticipation daoParticipation) {
		this.daoParticipation = daoParticipation;
	}



	
	
	
	
	
	

}

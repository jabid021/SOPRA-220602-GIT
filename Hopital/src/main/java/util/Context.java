package util;

import java.util.LinkedList;

import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import dao.jdbc.DAOCompteJDBC;
import dao.jdbc.DAOPatientJDBC;
import dao.jdbc.DAOVisiteJDBC;
import model.Compte;
import model.Patient;

public class Context {
	
	private LinkedList<Patient> fileAttente = new LinkedList();
	private IDAOCompte daoC = new DAOCompteJDBC();
	private IDAOPatient daoP = new DAOPatientJDBC();
	private IDAOVisite daoV = new DAOVisiteJDBC();
	private Compte connected;
	private boolean enPause = false;
	
	
	private static Context _instance;
	
	
	private Context() {}


	public static Context getInstance() {
		
		if(_instance==null) 
		{
			_instance=new Context();
		}
		return _instance;
		
		
	}


	public void set_singleton(Context _instance) {
		this._instance = _instance;
	}
	
	
	
	public LinkedList<Patient> getFileAttente() {
		return fileAttente;
	}


	public void setFileAttente(LinkedList<Patient> fileAttente) {
		this.fileAttente = fileAttente;
	}


	public IDAOCompte getDaoC() {
		return daoC;
	}


	public void setDaoC(IDAOCompte daoC) {
		this.daoC = daoC;
	}


	public IDAOPatient getDaoP() {
		return daoP;
	}


	public void setDaoP(IDAOPatient daoP) {
		this.daoP = daoP;
	}


	public IDAOVisite getDaoV() {
		return daoV;
	}


	public void setDaoV(IDAOVisite daoV) {
		this.daoV = daoV;
	}


	public Compte getConnected() {
		return connected;
	}


	public void setConnected(Compte connected) {
		this.connected = connected;
	}


	public boolean isEnPause() {
		return enPause;
	}


	public void setEnPause(boolean enPause) {
		this.enPause = enPause;
	}



	
	
	
	
	
	

}

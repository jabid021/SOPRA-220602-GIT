package dao;

import model.Compte;

public interface IDAOCompte extends IDAO <Compte, Integer>{
	
	public Compte seConnecter(String mail, String password);

}

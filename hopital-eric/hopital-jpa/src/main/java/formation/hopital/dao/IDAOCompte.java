package formation.hopital.dao;

import formation.hopital.model.Compte;

public interface IDAOCompte extends IDAO<Compte,Integer>{

	
	public Compte connect(String login,String password);
}

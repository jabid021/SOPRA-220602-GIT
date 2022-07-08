package formation.hopital.dao;

import java.util.List;

import formation.hopital.model.Visite;

public interface IDAOVisite extends IDAO<Visite,Integer>{

	
	public List<Visite> findAllByIdPatient(int idPatient);
}

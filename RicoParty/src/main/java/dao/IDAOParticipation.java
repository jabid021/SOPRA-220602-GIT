package dao;

import java.util.List;

import model.Participation;

public interface IDAOParticipation extends IDAO<Participation,Integer>{
	

		
		public List<Participation> findAllByIdEvent(int idEvent);
	

}

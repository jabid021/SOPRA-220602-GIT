package dao;

import java.util.List;

import model.Message;

public interface IDAOMessage extends IDAO <Message,Integer>{
	public List<Message> findAllByIdEvent(int idEvent);
}

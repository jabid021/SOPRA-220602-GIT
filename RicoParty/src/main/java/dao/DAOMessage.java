package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.Message;
import model.User;

public class DAOMessage implements IDAO<Message,Integer> {

	@Override
	public Message findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> findAll() {
		DAOCompte daoC = new DAOCompte();
		List<Message> messages = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from message");

			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				User expediteur = (User) daoC.findById(rs.getInt("id_user"));
				
				Message m  = new Message(rs.getInt("ID"), rs.getString("contenu"), LocalDate.parse(rs.getString("date_message")), LocalTime.parse(rs.getString("heure_message")), expediteur, null);
				messages.add(m);
			}
			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return messages;
	}

	@Override
	public void insert(Message m) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO message (contenu,date_message,heure_message,id_event,id_user) VALUES(?,?,?,?,?)");
			ps.setString(1, m.getContent());
			ps.setString(2, m.getDate().toString()); 
			ps.setString(3, m.getHeure().toString());
			ps.setInt(4, m.getEvent().getId());
			ps.setInt(5, m.getUser().getId());



			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void save(Message o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
	}


	public List<Message> findAllByIdEvent(Integer idEvent) 
	{
		DAOCompte daoC = new DAOCompte();
		List<Message> messages = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from message where id_event=?");
			ps.setInt(1, idEvent);

			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				User expediteur = (User) daoC.findById(rs.getInt("id_user"));
				
				Message m  = new Message(rs.getInt("ID"), rs.getString("contenu"), LocalDate.parse(rs.getString("date_message")), LocalTime.parse(rs.getString("heure_message")), expediteur, null);
				messages.add(m);
			}
			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return messages;
	}

	

}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.Adresse;
import model.Event;
import model.Message;
import model.User;

public class DAOEvent implements IDAO<Event,Integer> {

	@Override
	public Event findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> findAll() {
		
		DAOCompte daoC = new DAOCompte();
		
		List<Event> events = new ArrayList();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from event");

			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				User organisateur =  (User) daoC.findById(rs.getInt("id_createur"));
		
				Adresse a = new Adresse (rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"));
				Event e  = new Event(rs.getInt("id"),LocalDate.parse(rs.getString("date_event")),LocalTime.parse(rs.getString("heure_event")),rs.getString("titre"), rs.getString("description"), rs.getInt("taille_max"),rs.getInt("accompagnant_max"),rs.getDouble("prix"),rs.getString("password"),organisateur, null, null , null , a);
				events.add(e);
			}
			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) 
		{

			e.printStackTrace();
		}



		return events;
	}

	@Override
	public Event insert(Event e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO event (date_event,heure_event,titre, description, taille_max, accompagnant_max, prix, password, id_createur, numero, voie, ville, cp) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, e.getDate().toString());
			ps.setString(2,e.getHeure().toString());
			ps.setString(3, e.getTitre());
			ps.setString(4, e.getDescription());
			ps.setInt(5, e.getTailleMax());
			ps.setInt(6,e.getAccompagnantMax());
			ps.setDouble(7, e.getPrix());
			ps.setString(8, e.getPassword());
			ps.setInt(9, e.getCreateur().getId());
			ps.setString(10, e.getAdresse().getNumero());
			ps.setString(11,e.getAdresse().getVoie());
			ps.setString(12, e.getAdresse().getVille());
			ps.setString(13, e.getAdresse().getCp());


			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception ee) {
			ee.printStackTrace();
		}
		return e;

	}

	@Override
	public Event save(Event o) {
		return o;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	

}

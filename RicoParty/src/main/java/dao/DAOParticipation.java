package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Participation;
import model.User;

public class DAOParticipation implements IDAO<Participation,Integer> {

	@Override
	public Participation findById(Integer id) {
		DAOCompte daoC = new DAOCompte();
		
		Participation p=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from participation where id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();


			while(rs.next())
			{

				User participant =  (User) daoC.findById(rs.getInt("id_participant"));
				p = new Participation(rs.getInt("id"), rs.getInt("nb_personne"),rs.getString("accompagnants"), participant, null,null );

			}
			rs.close();
			ps.close();
			conn.close();


		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Participation> findAll() {
		
		DAOCompte daoC = new DAOCompte();
		
		Participation p=null;
		List<Participation> participations = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from participation");

			ResultSet rs = ps.executeQuery();


			while(rs.next())
			{

				User participant =  (User) daoC.findById(rs.getInt("id_participant"));
				p = new Participation(rs.getInt("id"), rs.getInt("nb_personne"),rs.getString("accompagnants"), participant, null,null );

				participations.add(p);
			}
			rs.close();
			ps.close();
			conn.close();


		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return participations;
	}

	@Override
	public Participation insert(Participation p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Participation ( nb_personne, accompagnants, id_participant, id_event) VALUES (?,?,?,?)");
			ps.setInt(1,p.getNbPersonne());
			ps.setString(2,p.getInvites());
			ps.setInt(3,p.getUser().getId());
			ps.setInt(4,p.getEvent().getId());

			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return p;	

	}

	@Override
	public Participation save(Participation p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("Update Participation  set nb_personne= ?, accompagnants=?, id_participant=?, id_event=? where id=?");
			ps.setInt(1,p.getNbPersonne());
			ps.setString(2,p.getInvites());
			ps.setInt(3,p.getUser().getId());
			ps.setInt(4,p.getEvent().getId());
			ps.setInt(5, p.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return p;	
	}

	@Override
	public void delete(Integer id) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("Delete from Participation  where id=?");
			
			ps.setInt(1, id);

			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	public List<Participation> findAllByIdEvent(Integer idEvent) {
		
		DAOCompte daoC = new DAOCompte();
		
		Participation p=null;
		List<Participation> participations = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from participation where id_event=?");
			ps.setInt(1, idEvent);
			
			ResultSet rs = ps.executeQuery();


			while(rs.next())
			{

				User participant =  (User) daoC.findById(rs.getInt("id_participant"));
				p = new Participation(rs.getInt("id"), rs.getInt("nb_personne"),rs.getString("accompagnants"), participant, null,null );

				participations.add(p);
			}
			rs.close();
			ps.close();
			conn.close();


		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return participations;
	}
	

}

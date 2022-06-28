package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Compte;
import model.User;

public class DAOCompte implements IDAO<Compte,Integer> {

	@Override
	public Compte findById(Integer id) {
		Compte c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id=? ");
			ps.setInt(1,id);

			ResultSet rs = ps.executeQuery();


			while(rs.next())
			{
				if(rs.getString("type_compte").equals("admin")) 
				{
					c = new Admin(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("password"));

				}
				else 
				{
					c = new User(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("password"),null);

				}

			}
			rs.close();
			ps.close();
			conn.close();


		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Compte> findAll() {
		Compte c=null;
		List<Compte> comptes = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte");

			ResultSet rs = ps.executeQuery();


			while(rs.next())
			{
				if(rs.getString("type_compte").equals("admin")) 
				{
					c = new Admin(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("password"));

				}
				else 
				{
					c = new User(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("password"),null);

				}
				comptes.add(c);
			}
			rs.close();
			ps.close();
			conn.close();


		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return comptes;

	}

	@Override
	public Compte insert(Compte c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (nom,prenom,mail,password,type_compte) VALUES(?,?,?,?,?)");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom()); 
			ps.setString(3, c.getMail());
			ps.setString(4, c.getPassword());
			
			if(c instanceof Admin) 
			{
				ps.setString(5, "admin");
			}
			else if (c instanceof User) 
			{
				ps.setString(5, "user");
			} 
			

			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return c;	
	}

	@Override
	public Compte save(Compte o) {
		return o;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("DELETE FROM compte where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

	
	
	public Compte seConnecter(String mail, String password) 
	{

		Compte c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where mail=? and password=?");
			ps.setString(1,mail);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();


			while(rs.next())
			{
				if(rs.getString("type_compte").equals("admin")) 
				{
					c = new Admin(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("password"));

				}
				else 
				{
					c = new User(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("mail"), rs.getString("password"),null);

				}

			}
			rs.close();
			ps.close();
			conn.close();


		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}

package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dao.IDAOPatient;
import model.Patient;

public class DAOPatientJDBC implements IDAOPatient{

	@Override
	public Patient findById(Integer id) {
		Patient p = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital","root","");

			PreparedStatement ps = connect.prepareStatement("SELECT * from patient where id=?");
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				 p = new Patient(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"));
			}
			rs.close();
			ps.close();
			connect.close();

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Patient> findAll() {
		return null;
	}



	@Override
	public void insert(Patient p) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital","root","");

			PreparedStatement ps = connect.prepareStatement("INSERT INTO patient (id,nom,prenom) VALUES(?,?,?)");
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getPrenom());
			ps.executeUpdate();

			ps.close();
			connect.close();

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Patient o) {
		
	}

	@Override
	public void delete(Patient o) {
		
	}

}

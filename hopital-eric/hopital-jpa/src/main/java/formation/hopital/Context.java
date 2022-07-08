package formation.hopital;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import formation.hopital.dao.IDAOCompte;
import formation.hopital.dao.IDAOMedecin;
import formation.hopital.dao.IDAOPatient;
import formation.hopital.dao.IDAOVisite;
import formation.hopital.dao.jpa.DAOCompte;
import formation.hopital.dao.jpa.DAOMedecin;
import formation.hopital.dao.jpa.DAOPatient;
import formation.hopital.dao.jpa.DAOVisite;

public class Context {

	private final EntityManagerFactory emf;

	private final IDAOCompte daoCompte = new DAOCompte();
	private final IDAOMedecin daoMedecin = new DAOMedecin();
	private final IDAOPatient daoPatient = new DAOPatient();
	private final IDAOVisite daoVisite = new DAOVisite();

	private static Context _instance;

	private Context() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		this.emf = Persistence.createEntityManagerFactory("hopital-jpa");
	}

	public static Context getInstance() {

		if (_instance == null) {
			_instance = new Context();
		}
		return _instance;

	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public IDAOMedecin getDaoMedecin() {
		return daoMedecin;
	}

	public IDAOPatient getDaoPatient() {
		return daoPatient;
	}

	public IDAOVisite getDaoVisite() {
		return daoVisite;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

}

package model;

public class Admin extends Compte {

	public Admin(Integer id, String nom, String prenom, String mail, String password) {
		super(id, nom, prenom, mail, password);
	}
	
	public Admin(String nom, String prenom, String mail, String password) {
		super(nom, prenom, mail, password);
	}


	@Override
	public String toString() {
		return "Admin [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", password=" + password
				+ "]";
	}

	
	

}
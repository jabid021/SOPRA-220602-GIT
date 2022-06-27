package model.single;

import javax.persistence.Entity;

@Entity
public class User extends Compte {
	
	
	private String prenom;
	
	public User() {
		super();
	}

	public User(String login, String password, String prenom) {
		super(login, password);
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}

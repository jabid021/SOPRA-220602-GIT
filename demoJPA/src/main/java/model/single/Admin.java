package model.single;

import javax.persistence.Entity;

@Entity
public class Admin extends Compte {

	public Admin() {
		super();
	}


	public Admin(String login, String password) {
		super(login,password);
	}


}

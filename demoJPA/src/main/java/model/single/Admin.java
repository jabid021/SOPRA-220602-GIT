package model.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("responsable")
public class Admin extends Compte {

	public Admin() {
		super();
	}


	public Admin(String login, String password) {
		super(login,password);
	}


}

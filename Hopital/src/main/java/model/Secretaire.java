package model;

public class Secretaire extends Compte {

	public Secretaire(String login) {
		super(login);
	}

	@Override
	public String toString() {
		return "Secretaire [id=" + id + ", login=" + login + ", password=" + password + "]";
	}

	
	
}

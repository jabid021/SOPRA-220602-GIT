package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Medecin extends Compte {

	private transient int salle;
	
	@OneToMany
	private List<Visite> visites = new ArrayList();
	
	
	public Medecin() {
		// TODO Auto-generated constructor stub
	}
	
	public Medecin(int id,String login) {
		super(login);
		this.id=id;
	}
	
	public Medecin(String login) {
		super(login);
	}


	public int getSalle() {
		return salle;
	}


	public void setSalle(int salle) {
		this.salle = salle;
	}


	public List<Visite> getVisites() {
		return visites;
	}


	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}


	@Override
	public String toString() {
		return "Medecin [salle=" + salle + ", visites=" + visites + ", id=" + id + ", login=" + login + ", password="
				+ password + "]";
	}
	
	
	
}

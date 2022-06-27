package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Obligatoire / permet de creer une table dans la bdd
@Entity
public class Visite {
	
	//Obligatoire / permet de specifier quelle est la PK
	@Id
	
	//Semi-Obligatoire / precise qu'on veut un auto-increment pour cette PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private transient Medecin medecin;
	private transient Patient patient;
	private LocalDate dateVisite;
	private double prix=20;
	private int salle;
	
	
	//Obligatoire 
	public Visite() {
	}
	
	public Visite(int id, Medecin medecin, Patient patient, String dateVisite, double prix, int salle) {
		this.id = id;
		this.medecin = medecin;
		this.patient = patient;
		this.dateVisite = LocalDate.parse(dateVisite);
		this.prix = prix;
		this.salle = salle;
	}
	
	
	
	public Visite(Medecin medecin, Patient patient) {
		this.medecin = medecin;
		this.patient = patient;
		this.dateVisite = LocalDate.now();
		this.salle = medecin.getSalle();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Medecin getMedecin() {
		return medecin;
	}



	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}



	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public LocalDate getDateVisite() {
		return dateVisite;
	}



	public void setDateVisite(String dateVisite) {
		this.dateVisite = LocalDate.parse(dateVisite);
	}



	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}



	public int getSalle() {
		return salle;
	}



	public void setSalle(int salle) {
		this.salle = salle;
	}



	@Override
	public String toString() {
		return "Visite [id=" + id + ", medecin=" + medecin.login + ", patient=" + patient + ", dateVisite=" + dateVisite
				+ ", prix=" + prix + ", salle=" + salle + "]";
	}
	
	
	
	
	

}

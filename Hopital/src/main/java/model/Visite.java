package model;

import java.time.LocalDate;

public class Visite {
	
	private int id;
	private Medecin medecin;
	private Patient patient;
	private LocalDate dateVisite;
	private double prix=20;
	private int salle;
	
	
	
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

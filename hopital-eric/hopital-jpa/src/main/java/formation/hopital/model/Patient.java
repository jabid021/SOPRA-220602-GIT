package formation.hopital.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Homme','Femme','NB')")
	private Civilite civ;
	
	
	public Patient() {}
	
	
	public Patient(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	
	
	public Patient(String nom, String prenom,Civilite civ) {
		this.nom = nom;
		this.prenom = prenom;
		this.civ=civ;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	

	public Civilite getCiv() {
		return civ;
	}

	public void setCiv(Civilite civ) {
		this.civ = civ;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	
}

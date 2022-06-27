package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_personne",columnDefinition = "ENUM('customer','supplier')")
@Table(name="person")
public abstract class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_person")
	protected Integer id;
	
	@Column(name="firstname",length =25 )
	protected String prenom;
	
	@Column(name="lastname",length = 50,nullable = false)
	protected String nom;
	
	@Embedded
	protected Adresse adresse;
	
	public Personne() {
	}
	
	
	public Personne(String prenom, String nom,Adresse adresse) {
		this.prenom = prenom;
		this.nom = nom;
		this.adresse=adresse;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	
	
}

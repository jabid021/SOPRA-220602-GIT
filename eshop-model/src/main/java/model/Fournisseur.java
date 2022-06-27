package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("supplier")
public class Fournisseur extends Personne {

	@Column(name="society",length = 30,unique = true)
	private String societe;
	
	public Fournisseur() {
	}

	public Fournisseur(String prenom, String nom, Adresse adresse, String societe) {
		super(prenom, nom, adresse);
		this.societe = societe;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}
	
	
}

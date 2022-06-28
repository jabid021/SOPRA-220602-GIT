package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("supplier")
public class Fournisseur extends Personne {

	@Column(name="society",length = 30,unique = true)
	private String societe;
	
	
	@OneToMany(mappedBy = "vendeur")
	private List<Produit> stock;
	
	
	
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



	public List<Produit> getStock() {
		return stock;
	}



	public void setStock(List<Produit> stock) {
		this.stock = stock;
	}



	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", adresse=" + adresse + ", societe="
				+ societe +  "]";
	}
	
	
	
}

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String libelle;
	
	@Column(columnDefinition = "decimal(6, 2)")
	private double prix;
	
	
	@ManyToOne
	private Fournisseur vendeur;
	
	
	
	public Produit() {
	}
	
	
	

	public Produit(String libelle, double prix, Fournisseur vendeur) {
		this.libelle = libelle;
		this.prix = prix;
		this.vendeur = vendeur;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Fournisseur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Fournisseur vendeur) {
		this.vendeur = vendeur;
	}
	
	
	
}

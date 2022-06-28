package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Achat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="date_achat")
	private LocalDate dateAchat;
	
	private int quantite;
	
	private double prixTTC;
	
	@ManyToOne
	@JoinColumn(name="produit")
	private Produit produit;
	
	
	
	@ManyToOne
	@JoinColumn(name="acheteur")
	private Client acheteur;
	
	
	public Achat() {
	}


	


	public Achat(int quantite, Produit produit, Client acheteur) {
		this.quantite = quantite;
		this.produit = produit;
		this.acheteur = acheteur;
		this.dateAchat=LocalDate.now();
		this.prixTTC=produit.getPrix();
	}





	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getDateAchat() {
		return dateAchat;
	}


	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	public Client getAcheteur() {
		return acheteur;
	}


	public void setAcheteur(Client acheteur) {
		this.acheteur = acheteur;
	}





	public int getQuantite() {
		return quantite;
	}





	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}





	public double getPrixTTC() {
		return prixTTC;
	}





	public void setPrixTTC(double prixTTC) {
		this.prixTTC = prixTTC;
	}





	@Override
	public String toString() {
		return "Achat [id=" + id + ", dateAchat=" + dateAchat + ", quantite=" + quantite + ", prixTTC=" + prixTTC
				+ ", produit=" + produit + ", acheteur=" + acheteur + "]";
	}
	
	
	
	
	

}

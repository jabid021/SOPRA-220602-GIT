package formation.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "achat")
public class Achat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACH_ID")
	@JsonView(Views.ViewCommon.class)
	private Long id;

	@Column(name = "ACH_QUANTITE", nullable = false)
	@JsonView(Views.ViewCommon.class)
	private int quantite;

	@Column(name = "ACH_MONTANT", precision = 10, scale = 2, nullable = false)
	@JsonView(Views.ViewCommon.class)
	private Double prix;

	@ManyToOne
	@JoinColumn(name = "ACH_COMMANDE_ID")
	@JsonView(Views.ViewAchat.class)
	private Commande commande;

	@ManyToOne
	@JoinColumn(name = "ACH_PRODUIT_ID")
	@JsonView({ Views.ViewAchat.class, Views.ViewCommandeDetail.class })
	private Produit produit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Achat() {
		// Rien de sp�cial ici
	}

	public Achat(Double prix, int quantite, Produit produit, Commande commande) {
		this.prix = prix;
		this.quantite = quantite;
		this.produit = produit;
		this.commande = commande;
	}

	@Override
	public String toString() {
		return this.prix + " euros, " + this.quantite + " produit(s) : " + this.produit;
	}
}

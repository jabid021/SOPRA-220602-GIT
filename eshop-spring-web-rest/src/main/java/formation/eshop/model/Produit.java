package formation.eshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "produit")
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_ID")
	@JsonView(Views.ViewCommon.class)
	private Long id;

	@Column(name = "PRO_NOM", length = 150)
	@Size(min = 3, max = 150, message = "Le libellé doit avoir entre 3 et 150 caractères")
	@JsonView(Views.ViewCommon.class)
	private String libelle;

	@Column(name = "PRO_PRIX_ACHAT", precision = 10, scale = 2)
	@JsonView(Views.ViewCommon.class)
	private Double prixAchat;

	@Column(name = "PRO_PRIX_VENTE", precision = 10, scale = 2)
	@JsonView(Views.ViewCommon.class)
	private Double prixVente;

	@Column(name = "PRO_REFERENCE", length = 100)
	@JsonView(Views.ViewCommon.class)
	private String reference;

	@Column(name = "PRO_STOCK")
	@JsonView(Views.ViewCommon.class)
	private int stock;

	@ManyToOne
	@JoinColumn(name = "PRO_FOURNISSEUR_ID")
	@JsonView(Views.ViewProduitDetail.class)
	private Fournisseur fournisseur;

	@OneToMany(mappedBy = "produit")
	private List<Achat> achats = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(Double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public Double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Double prixVente) {
		this.prixVente = prixVente;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	public Produit() { // IMPORTANT pour JPA

	}

	public Produit(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return " > " + this.id + ". " + this.libelle + ", " + this.prixVente + " euros";
	}
}

package formation.eshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("fournisseur")
public class Fournisseur extends Personne {
	@Column(name = "FOU_SOCIETE", length = 200)
	private String societe;

	@OneToMany(mappedBy = "fournisseur")
	private List<Produit> produits = new ArrayList<>();

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}

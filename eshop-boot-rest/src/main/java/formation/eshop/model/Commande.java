package formation.eshop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CMD_ID")
	@JsonView(Views.ViewCommon.class)
	private Long id;

	@Column(name = "CMD_DATE")
	@Temporal(TemporalType.DATE)
	@JsonView(Views.ViewCommon.class)
	private Date date;

	@JsonView(Views.ViewCommon.class)
	private Double prixTotal;

	@Enumerated(EnumType.STRING)
	@Column(name = "CMD_ETAT")
	@JsonView(Views.ViewCommon.class)
	private EtatCommande etat;

	@ManyToOne
	@JoinColumn(name = "CMD_CLIENT_ID")
	@JsonView(Views.ViewCommande.class)
	private Client client;

	@OneToMany(mappedBy = "commande")
	@JsonView(Views.ViewCommandeDetail.class)
	private List<Achat> achats = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public EtatCommande getEtat() {
		return etat;
	}

	public void setEtat(EtatCommande etat) {
		this.etat = etat;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

}

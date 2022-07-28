package formation.eshop.rest.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PanierDTO {
	private String nomClient;
	private String emailClient;

	private Long idCommande;
	private Date dateCommande;
	private Double prixTotalCommande;

	private List<PanierLigneDTO> lignes = new ArrayList<>();

	public PanierDTO() {
		super();
	}

	public PanierDTO(String nomClient, String emailClient, Long idCommande, Date dateCommande,
			Double prixTotalCommande) {
		super();
		this.nomClient = nomClient;
		this.emailClient = emailClient;
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.prixTotalCommande = prixTotalCommande;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Double getPrixTotalCommande() {
		return prixTotalCommande;
	}

	public void setPrixTotalCommande(Double prixTotalCommande) {
		this.prixTotalCommande = prixTotalCommande;
	}

	public List<PanierLigneDTO> getLignes() {
		return lignes;
	}

	public void setLignes(List<PanierLigneDTO> lignes) {
		this.lignes = lignes;
	}
	
	public void addLigne(PanierLigneDTO ligne) {
		this.lignes.add(ligne);
	}

}

package formation.eshop.rest.dto;

public class PanierLigneDTO {
	private String libelleProduit;
	private Double prixVenteProduit;

	private int quantiteAchat;
	private Double prixAchat;

	public PanierLigneDTO() {
		super();
	}

	public PanierLigneDTO(String libelleProduit, Double prixVenteProduit, int quantiteAchat, Double prixAchat) {
		super();
		this.libelleProduit = libelleProduit;
		this.prixVenteProduit = prixVenteProduit;
		this.quantiteAchat = quantiteAchat;
		this.prixAchat = prixAchat;
	}

	public String getLibelleProduit() {
		return libelleProduit;
	}

	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}

	public Double getPrixVenteProduit() {
		return prixVenteProduit;
	}

	public void setPrixVenteProduit(Double prixVenteProduit) {
		this.prixVenteProduit = prixVenteProduit;
	}

	public int getQuantiteAchat() {
		return quantiteAchat;
	}

	public void setQuantiteAchat(int quantiteAchat) {
		this.quantiteAchat = quantiteAchat;
	}

	public Double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(Double prixAchat) {
		this.prixAchat = prixAchat;
	}

}

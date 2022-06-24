package model;

public class Contribution {
	private Integer id;
	private Categorie categorie;
	private String description;
	
	
	public Contribution(Integer id, Categorie categorie, String description) {
		this.id = id;
		this.categorie = categorie;
		this.description = description;
	}
	
	public Contribution( Categorie categorie, String description) {
		this.categorie = categorie;
		this.description = description;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Contribution [id=" + id + ", categorie=" + categorie + ", description=" + description + "]";
	}
	
	
	

}

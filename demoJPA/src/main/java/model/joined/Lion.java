package model.joined;

public class Lion extends Animal{
	
	private String couleur;

	public Lion() {
		super();
	}
	
	public Lion(String couleur) {
		super(true, false);
		this.couleur = couleur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	

}


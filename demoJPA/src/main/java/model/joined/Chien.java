package model.joined;

public class Chien extends Animal {

	private String race;

	public Chien() {
		super();
	}
	
	
	public Chien(String race) {
		super(true, false);
		this.race = race;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}
	
	
	
	
}

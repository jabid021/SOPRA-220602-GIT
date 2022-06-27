package model.table;

public class Avion extends Vehicule {

	private String carburant;
	private String compagnie;
	
	
	public Avion() {
		super();
	}
	
	
	public Avion(int roues, String carburant, String compagnie) {
		super(roues);
		this.carburant = carburant;
		this.compagnie = compagnie;
	}


	public String getCarburant() {
		return carburant;
	}


	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}


	public String getCompagnie() {
		return compagnie;
	}


	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}
	
	
	
	
	
	
	
}

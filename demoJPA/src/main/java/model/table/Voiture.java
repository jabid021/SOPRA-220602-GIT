package model.table;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
 @Table(name="car")
public class Voiture extends Vehicule{
	
	private String marque;

	
	public Voiture() {
		super();
	}
	public Voiture(int roues, String marque) {
		super(roues);
		this.marque = marque;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	
	

}

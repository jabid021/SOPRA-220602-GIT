package model.table;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
 @Table(name="boat")
public class Bateau extends Vehicule{
	
	private String marque;

	
	public Bateau() {
		super();
	}
	public Bateau(int roues, String marque) {
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

package model.table;

public abstract class Vehicule {
	
	protected Integer id;
	protected int roues;
	
	public Vehicule() {
	}

	public Vehicule(int roues) {
		this.roues = roues;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getRoues() {
		return roues;
	}

	public void setRoues(int roues) {
		this.roues = roues;
	}

	
	
}

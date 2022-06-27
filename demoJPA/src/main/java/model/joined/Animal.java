package model.joined;

public abstract class Animal {

	
	
	protected Integer id;
	
	protected boolean carnivore;
	protected boolean herbivore;
	
	
	public Animal() {
	}


	public Animal(boolean carnivore, boolean herbivore) {
		this.carnivore = carnivore;
		this.herbivore = herbivore;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public boolean isCarnivore() {
		return carnivore;
	}


	public void setCarnivore(boolean carnivore) {
		this.carnivore = carnivore;
	}


	public boolean isHerbivore() {
		return herbivore;
	}


	public void setHerbivore(boolean herbivore) {
		this.herbivore = herbivore;
	}
	
	
	
}

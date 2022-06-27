package model.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="id_chien")
@Table(name="dog")
public class Chien extends Animal {

	@Column(nullable=false)
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

package model.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(sequenceName = "seqVehiculeBdd", name = "seqVehiculeJPA")
public abstract class Vehicule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqVehiculeJPA")
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

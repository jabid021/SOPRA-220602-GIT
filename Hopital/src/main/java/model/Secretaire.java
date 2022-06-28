package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Secretaire extends Compte {

	//deux col de jointures => id secretaire (princip) + id patient (id inverse)
	@ManyToMany
	@JoinTable
	(
		name="rdv",
		joinColumns = @JoinColumn(name="secretaire"),
		inverseJoinColumns = @JoinColumn(name="patient"),
		uniqueConstraints= @UniqueConstraint(columnNames = { "secretaire", "patient" })
		
	)
	private List<Patient> patients = new ArrayList();
	
	
	public Secretaire() {
	}
	
	public Secretaire(Integer id,String login,String password) {
		super(id,login,password);
	}
	
	public Secretaire(String login,String password) {
		super(login,password);
	}

	
	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Secretaire [id=" + id + ", login=" + login + ", password=" + password + "]";
	}

	
	
}

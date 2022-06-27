package model.single;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("user")
public class User extends Compte {
	
	
	@Column(name="firstname")
	private String prenom;
	
	
	@Embedded
	private ConfigPc config;
	
	private LocalDate naissance;
	
	public User() {
		super();
	}

	public User(String login, String password, String prenom,LocalDate naissance,ConfigPc config) {
		super(login, password);
		this.prenom = prenom;
		this.naissance=naissance;
		this.config=config;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	public ConfigPc getConfig() {
		return config;
	}

	public void setConfig(ConfigPc config) {
		this.config = config;
	}
	
	

	
}

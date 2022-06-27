package model.single;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte",columnDefinition = ("ENUM('user','responsable')"))
@Table(name="account")
public abstract class Compte {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_compte")
	protected Integer id;
	
	
	@Column(unique = true,nullable = false,columnDefinition = "VARCHAR(25)")
	protected String login;
	
	@Column(name="mot_de_passe",nullable = false,length = 125)
	protected String password;
	
	public Compte() {
	}

	
	public Compte(String login, String password) {
		this.login = login;
		this.password = password;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}

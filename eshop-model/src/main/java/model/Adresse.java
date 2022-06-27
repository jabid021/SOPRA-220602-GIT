package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	private String numero;
	
	@Column(name="street",nullable=false,length = 25)
	private String voie;
	
	@Column(name="city",nullable=false,length =50)
	private String ville;
	
	@Column(name="zipcode",nullable=false,length = 5)
	private String cp;
	
	public Adresse() {
	}

	public Adresse(String numero, String voie, String ville, String cp) {
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp = cp;
	}
	
	
}

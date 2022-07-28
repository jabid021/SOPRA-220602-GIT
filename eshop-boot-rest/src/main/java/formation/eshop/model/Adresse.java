package formation.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "adresse")
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADR_ID")
	@JsonView(Views.ViewCommon.class)
	private Long id;

	@Column(name = "ADR_RUE", length = 200, nullable = false)
	@NotBlank(message = "La rue est obligatoire")
	@JsonView(Views.ViewCommon.class)
	private String rue;

	@Column(name = "ADR_VILLE", length = 150)
	@Size(min = 2, message = "La ville doit avoir au moins 2 caractères")
	@JsonView(Views.ViewCommon.class)
	private String ville;

	@Column(name = "ADR_CP", length = 10)
	@Pattern(regexp = "^((0[1-9])|([1-8][0-9])|(9[0-8])|(2A)|(2B))[0-9]{3}$", message = "Le code postal doit être composé de 5 chiffres")
	@JsonView(Views.ViewCommon.class)
	private String codePostal;

	public Adresse() {
		super();
	}

	public Adresse(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
}

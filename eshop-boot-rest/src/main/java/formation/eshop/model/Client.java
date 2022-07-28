package formation.eshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("client")
public class Client extends Personne {
	@JsonView(Views.ViewCommon.class)
	private int age;

	@Column(name = "CLI_EMAIL", length = 255)
	@JsonView(Views.ViewCommon.class)
	private String email;

	@Column(name = "CLI_COMMENTS", length = 4000)
	@JsonView(Views.ViewCommon.class)
	private String commentaires;

	@OneToMany(mappedBy = "client")
	@JsonView(Views.ViewClientDetail.class)
	private List<Commande> commandes = new ArrayList<>();

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
}

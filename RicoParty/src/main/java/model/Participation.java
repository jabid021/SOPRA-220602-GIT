package model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Participation {
	@Id
	@Column (length = 11)
	private Integer id;
	@Column (name= "nb_personne", length =11)
	private int nbPersonne;
	@Column (name= "accompagnants", length =75)
	private String invites;
	@ManyToOne
	@JoinColumn (name= "id_participant")
	private User user;
	private transient List <Contribution> contributions;
	@ManyToOne
	@JoinColumn (name= "id_event")
	private Event event;
	
	

	
	
	public Participation() {
	}


	public Participation(Integer id, int nbPersonne, String invites, User user, List<Contribution> contributions,
			Event event) {
		this.id = id;
		this.nbPersonne = nbPersonne;
		this.invites = invites;
		this.user = user;
		this.contributions = contributions;
		this.event = event;
	}

	
	public Participation(int nbPersonne, String invites, User user, List<Contribution> contributions,Event event) {
		this.nbPersonne = nbPersonne;
		this.invites = invites;
		this.user = user;
		this.contributions = contributions;
		this.event = event;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public int getNbPersonne() {
		return nbPersonne;
	}


	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

	public String getInvites() {
		return invites;
	}

	public void setInvites(String invites) {
		this.invites = invites;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public List<Contribution> getContributions() {
		return contributions;
	}


	public void setContributions(List<Contribution> contributions) {
		this.contributions = contributions;
	}


	public Event getEvent() {
		return event;
	}


	public void setEvent(Event event) {
		this.event = event;
	}


	@Override
	public String toString() {
		return "Participation [id=" + id + ", nbPersonne=" + nbPersonne + ", invites=" + invites + ", user=" + user
				+ "]";
	}
	

}

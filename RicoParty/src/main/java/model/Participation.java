package model;

import java.util.List;
//A FAIRE//
public class Participation {
	
	private Integer id;
	private int nbPersonne;
	private String invites;
	private User user;
	private transient List <Contribution> contributions;
	private Event event;
	
	

	
	
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

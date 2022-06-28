package model;

import java.util.ArrayList;
import java.util.List;
//A FAIRE//
public class User extends Compte {
	
	private List <Message> messages=new ArrayList();
	private List<Participation> participations=new ArrayList();
	private List<Event> events=new ArrayList();
	
	
	public User(Integer id, String nom, String prenom, String mail, String password, List<Event> events) {
		super(id, nom, prenom, mail, password);
		this.events = events;
	}
	
	public User(String nom, String prenom, String mail, String password) {
		super(nom, prenom, mail, password);
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", password=" + password
				+ "]";
	}

	
	







}

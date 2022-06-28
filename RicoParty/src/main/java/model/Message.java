package model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

//A FAIRE//

@Entity
public class Message {
	
	@Id
	private Integer id;
	private String content;
	private LocalDate date;
	private LocalTime heure;
	private User user;
	private Event event;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	public Message(Integer id, String content, LocalDate date, LocalTime heure, User user, Event event) {
		
		this.id = id;
		this.content = content;
		this.date = date;
		this.heure = heure;
		this.user=user;
		this.event=event;
	}
	
	public Message(String content, LocalDate date, LocalTime heure, User user, Event event) {
	
		this.content = content;
		this.date = date;
		this.heure = heure;
		this.user=user;
		this.event=event;
	}

	public Integer getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	
	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", date=" + date + ", heure=" + heure + ", user=" + user
				+ "]";
	}

	

}

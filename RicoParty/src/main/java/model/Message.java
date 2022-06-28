package model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//A FAIRE//

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="contenu",length=150)
	private String content;
	
	@Column(name="date_message")
	private LocalDate date;
	
	@Column(name="heure_message")
	private LocalTime heure;
	
	@ManyToOne
	@JoinColumn(name="id_user")//length=11
	private User user;
	
	@ManyToOne
	@JoinColumn(name="id_event")//length=11
	private Event event;
	
	public Message() {
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

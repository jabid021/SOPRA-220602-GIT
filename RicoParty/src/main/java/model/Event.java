package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
//A FAIRE//

public class Event {

	private Integer id;
	private LocalDate date;
	private LocalTime heure;
	private String titre;
	private String description;
	private int tailleMax;
	private int accompagnantMax;
	private double prix;
	private String password;
	private User createur;
	private List <Message> messages=new ArrayList();
	private transient List <Contribution> demandes;
	private List <Participation> participants=new ArrayList();;
	private Adresse adresse;
	
	public Event (Integer id, LocalDate date,LocalTime heure,String titre,String description,int tailleMax,int accompagnantMax,double prix,String password,User createur,List<Message> messages,List<Contribution> demandes,List<Participation> participants,Adresse adresse){
		this.id=id;
		this.date=date;
		this.heure=heure;
		this.titre=titre;
		this.description=description;
		this.tailleMax=tailleMax;
		this.accompagnantMax=accompagnantMax;
		this.prix=prix;
		this.password=password;
		this.createur=createur;
		this.messages=messages;
		this.demandes=demandes;
		this.participants=participants;
		this.adresse=adresse;
	}
	
	
	

	public Event(LocalDate date, LocalTime heure, String titre, String description, int tailleMax, int accompagnantMax,
			double prix, String password, User createur, List<Contribution> demandes, Adresse adresse) {
		this.date = date;
		this.heure = heure;
		this.titre = titre;
		this.description = description;
		this.tailleMax = tailleMax;
		this.accompagnantMax = accompagnantMax;
		this.prix = prix;
		this.password = password;
		this.createur = createur;
		this.demandes = demandes;
		this.adresse = adresse;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTailleMax() {
		return tailleMax;
	}

	public void setTailleMax(int tailleMax) {
		this.tailleMax = tailleMax;
	}

	public int getAccompagnantMax() {
		return accompagnantMax;
	}

	public void setAccompagnantMax(int accompagnantMax) {
		this.accompagnantMax = accompagnantMax;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getCreateur() {
		return createur;
	}

	public void setCreateur(User createur) {
		this.createur = createur;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Contribution> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Contribution> demandes) {
		this.demandes = demandes;
	}

	public List<Participation> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participation> participants) {
		this.participants = participants;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", date=" + date + ", heure=" + heure + ", titre=" + titre + ", description="
				+ description + ", tailleMax=" + tailleMax + ", accompagnantMax=" + accompagnantMax + ", prix=" + prix
				+ ", password=" + password + ", createur=" + createur + ", message=" + messages + ", demandes="
				+ demandes + ", participants=" + participants + ", adresse=" + adresse + "]";
	}

}

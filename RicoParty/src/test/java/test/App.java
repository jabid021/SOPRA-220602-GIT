package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import javax.persistence.EntityManager;

import dao.DAOCompte;
import dao.DAOEvent;
import dao.DAOMessage;
import dao.DAOParticipation;
import model.Admin;
import model.Adresse;
import model.Compte;
import model.Event;
import model.Message;
import model.Participation;
import model.User;
import util.Context;

public class App {

	static Compte connected;
	
	
	static DAOCompte daoC = Context.getInstance().getDaoCompte();
	static DAOMessage daoM = Context.getInstance().getDaoMessage();
	static DAOParticipation daoP=  Context.getInstance().getDaoParticipation();
	static DAOEvent daoE = Context.getInstance().getDaoEvent();


	public static String saisieString(String msg) 
	{
		Scanner sc =new Scanner(System.in);
		System.out.println(msg);
		String var = sc.nextLine();
		return var;
	}

	public static int saisieInt(String msg) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println(msg);
		int var = scanner.nextInt();
		return var;
	}

	public static double saisieDouble(String msg) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println(msg);
		return scanner.nextDouble();
	}

	public static boolean saisieBoolean(String msg) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println(msg);
		boolean var = scanner.nextBoolean();
		return var;
	}


	public static void menuPrincipal() 
	{
		System.out.println("Appli Rico-Party");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Inscription");
		System.out.println("3 - Stop");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : inscription();break;
		case 3 : System.exit(0) ;break;
		}

		menuPrincipal();

	}


	public static void inscription() {

		String prenom =saisieString("Saisir votre pr�nom :" );
		String nom =saisieString("Saisir votre nom :" );
		String mail = saisieString("Saisir votre mail : ");
		String password = saisieString("Saisir votre password : ");


		User inscrit = new User(nom, prenom, mail,password);

		daoC.save(inscrit);

	}

	public static void seConnecter() {
		String mail = saisieString("Saisir votre mail : ");

		String password = saisieString("Saisir votre password : ");

		connected = daoC.connect(mail,password);


		if(connected==null) 
		{
			System.out.println("Identifiants invalides\n");
		}
		else if(connected instanceof Admin) 
		{
			menuAdmin();
		}
		else if(connected instanceof User) 
		{
			menuUser();
		}



	}


	public static void menuUser() 
	{
		System.out.println("Menu User - "+connected.getPrenom());
		System.out.println("1 - Creer un event");
		System.out.println("2 - Consulter un event");
		System.out.println("3 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : creerEvent();break;
		case 2 : consulterEvent();break;
		case 3 : menuPrincipal();break;
		}

		menuUser();

	}


	public static void consulterEvent() {
		int idEvent = saisieInt("Saisir l'id de l'event");
		
		
		System.out.println("Event numero "+idEvent+" : ");
		
		System.out.println("1 - Participer � l'event "+idEvent);
		System.out.println("2 - Envoyer un message � l'event");
		System.out.println("3 - Afficher tous les messages");
		System.out.println("4 - Afficher tous les participants de l'event");
		System.out.println("5 - Retour");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : participerEvent(idEvent);break;
		case 2 : envoyerMessage(idEvent);break;
		case 3 : afficherMessages(idEvent);break;
		case 4 : afficherParticipants(idEvent);break;
		case 5 : menuUser();break;
		}
		consulterEvent();

	}

	public static void afficherParticipants(int idEvent) {
		for(Participation p : daoP.findAllByIdEvent(idEvent)) 
		{
			System.out.println(p);
		}

		if(daoP.findAllByIdEvent(idEvent).isEmpty()) {System.out.println("Aucun participant pour cet event !");}

	}

	public static void afficherMessages(int idEvent) {

		for(Message m : daoM.findAllByIdEvent(idEvent)) 
		{
			System.out.println("Message de "+m.getUser().getPrenom()+" "+m.getUser().getNom()+" ("+m.getHeure()+", "+m.getDate()+")");
			System.out.println(m.getContent()+"\n");
		}
		if(daoM.findAllByIdEvent(idEvent).isEmpty()) 
		{
			System.out.println("Aucun message pour l'instant !");
		}

	}

	public static void envoyerMessage(int idEvent) {
		Event e = new Event(idEvent, null, null, null, null, 0, 0, 0, null, null, null, null, null, null);
		String message = saisieString("Saisir votre message");
		Message m = new Message(message, LocalDate.now(), LocalTime.now(), (User) connected, e);
		daoM.save(m);
		System.out.println("\nMessage Envoy� !\n");


	}

	public static void participerEvent(int idEvent) {
		int nbPersonne = saisieInt("Combien seriez vous?");
		String invites = saisieString("Avec qui?");



		//insertParticipation(p)
		Event e1 = new Event(idEvent,LocalDate.parse("2022-06-17"), LocalTime.parse("20:00:00"),"Mon Anniversaire", "Ca va etre bien !", 100,3, 0, "54321", (User) connected, null, null, null, null);

		Participation p= new Participation (nbPersonne,invites,(User)connected,null,e1);

		daoP.save(p);

	}

	public static void creerEvent() {
		String date = saisieString("Entrez la date de l'event" );
		String heure= saisieString("Entrez l'heure de l'event");
		String titre= saisieString("Entrez le titre de l'event");
		String description= saisieString("Entrez la description de l'event");
		int accompagnantMax= saisieInt("Entrez le nombre max d'accompagnants");
		double prix= saisieDouble("Entrez le prix d'entr�e");
		String numero= saisieString("Entrez l'adresse (numero) de l'event");
		String voie= saisieString("Entrez l'adresse (voie) de l'event");
		String ville= saisieString("Entrez l'adresse (ville) de l'event");
		String cp= saisieString("Entrez l'adresse (cp) de l'event");
		String password = saisieString("Saisir password event");

		Adresse a1 = new Adresse(numero,voie,ville,cp);

		Event e1 = new Event(LocalDate.parse(date),LocalTime.parse(heure), titre, description,50 ,accompagnantMax, prix, password,(User) connected,null,a1);


		daoE.save(e1);

	}

	public static void menuAdmin() 
	{
		System.out.println("Menu Admin");
		System.out.println("1 - Lister tous les events");
		System.out.println("2 - Lister tous les comptes");
		System.out.println("3 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : showEvents();break;
		case 2 : listerComptes();break;
		case 3 : menuPrincipal();break;
		}

		menuAdmin();

	}

	public static void listerComptes() {
		for(Compte c  : daoC.findAll()) {System.out.println(c);}

	}



	public static void showEvents() {
		for(Event e : daoE.findAll())
		{
			System.out.println(e);
		}
		if(daoE.findAll().isEmpty())
		{
			System.out.println("aucun event a afficher");
		}

	}

	public static void main(String[] args) {
		/*EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		em.close();
		
		
		menuPrincipal();*/

		System.out.println(daoM.findAllByIdEvent(2));
		Context.getInstance().getEmf().close();
	}

}

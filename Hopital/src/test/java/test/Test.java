package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import model.Compte;
import model.Medecin;
import model.Patient;
import model.Secretaire;
import model.Visite;
import util.Context;

public class Test {
	
	static IDAOCompte daoC = Context.getInstance().getDaoC();
	static IDAOPatient daoP = Context.getInstance().getDaoP();
	static IDAOVisite daoV = Context.getInstance().getDaoV();
	
	
	
	public static String saisieString(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}



	public static void menuPrincipal() {
		System.out.println("Appli Hopital");
		System.out.println("Choisir un menu");
		System.out.println("1- Se connecter");
		System.out.println("2- Fermer");

		int choix = saisieInt("");

		switch(choix)
		{
		case 1 : seConnecter();break;
		case 2 : System.exit(0);
		}
		menuPrincipal();
	}

	public static void seConnecter() {
		String login = saisieString("Saisir le login");
		String password = saisieString("Saisir le password");
		Compte connected=daoC.connect(login,password);
		Context.getInstance().setConnected(connected);

		if(connected instanceof Medecin) 
		{
			int salle = saisieInt("Choisir une salle (1/2)");
			((Medecin) Context.getInstance().getConnected()).setSalle(salle);
			menuMedecin();
		}
		else if(connected instanceof Secretaire) 
		{
			menuSecretaire();
		}
		else 
		{
			System.out.println("Identifiants invalides");
		}

		menuPrincipal();
	}

	public static void menuSecretaire() {
		System.out.println("Menu Secretaire "+Context.getInstance().getConnected().getLogin());
		System.out.println("Choisir un menu");
		if(Context.getInstance().isEnPause()==false) 
		{
			System.out.println("1- Recevoir un patient");
			System.out.println("2- Afficher les visites d'un patient");
			System.out.println("3- Afficher l'etat de la file d'attente");
			System.out.println("4- Partir en pause");
			System.out.println("5 - Se deconnecter");

			int choix = saisieInt("");

			switch(choix)
			{
			case 1 : addPatient();break;
			case 2 : showVisites();break;
			case 3 : showFile();break;
			case 4 : pause();break;
			case 5 : menuPrincipal();break;
			}
		}
		else 
		{
			System.out.println("1- Revenir de pause");
			System.out.println("2 - Se deconnecter");
			int choix = saisieInt("");

			switch(choix)
			{
			case 1 : retourPause();break;
			case 2 : menuPrincipal();break;
			}
		}
		menuSecretaire();
	}




	public static void retourPause() {
		
		File f = new File("fileAttente.txt");
		try(FileInputStream fis = new FileInputStream(f);ObjectInputStream ois = new ObjectInputStream(fis))
		{
			Context.getInstance().setFileAttente((LinkedList<Patient>) ois.readObject());
			Context.getInstance().setEnPause(false);
		}
		catch(Exception e) {System.err.println("Erreur pendant la déserialisation du fichier file d'attente");}
	}

	public static void pause() {
		File f = new File("fileAttente.txt");
		try(FileOutputStream fos = new FileOutputStream(f);ObjectOutputStream oos = new ObjectOutputStream(fos))
		{
			oos.writeObject(Context.getInstance().getFileAttente());
			Context.getInstance().setEnPause(true);
			Context.getInstance().getFileAttente().clear();
		}
		catch(Exception e) {System.err.println("Erreur pendant la serialisation du fichier file d'attente");}
	}

	public static void showFile() {

		if(Context.getInstance().getFileAttente().isEmpty()) 
		{
			System.out.println("Aucun patient dans la file d'attente");
		}

		for(Patient p : Context.getInstance().getFileAttente()) 
		{
			System.out.println(p);
		}
	}

	public static void showVisites() {
		int idPatient= saisieInt("Saisir l'id du patient");
		List<Visite> visites = daoV.findAllByIdPatient(idPatient);

		if(visites.isEmpty()) 
		{
			System.out.println("Ce patient n'a pas de visite");
		}

		for(Visite v : visites) 
		{
			System.out.println(v);
		}

	}

	public static void addPatient() {

		int idPatient= saisieInt("Saisir l'id du patient");
		Patient p = daoP.findById(idPatient);
		if(p==null) 
		{
			System.out.println("Inscription d'un nouveau patient !");
			String nom=saisieString("Saisir le nom du patient");
			String prenom=saisieString("Saisir le prenom du patient");
			p=new Patient(idPatient,nom,prenom);
			daoP.insert(p);
		}
		Context.getInstance().getFileAttente().add(p);
		System.out.println("Patient "+idPatient+" ajouté à la file");

	}

	public static void menuMedecin() {

		System.out.println("Menu Medecin "+Context.getInstance().getConnected().getLogin());
		System.out.println("Choisir un menu");

		System.out.println("1- Recevoir un patient");
		System.out.println("2- Afficher l'etat de la file d'attente");
		System.out.println("3- Sauvegarder mes visites");
		System.out.println("4 - Se deconnecter");

		int choix = saisieInt("");

		switch(choix)
		{
		case 1 : nextPatient();break;
		case 2 : showFile();break;
		case 3 : saveVisites();break;
		case 4 : saveVisites();menuPrincipal();break;
		}

		menuMedecin();
	}

	public static void saveVisites() {
		Medecin m = (Medecin)Context.getInstance().getConnected();
		if(m.getVisites().isEmpty()) 
		{
			System.out.println("Pas de visite à  sauvegarder");
		}
		
		for(Visite v : m.getVisites()) 
		{
			daoV.insert(v);
		}
		m.getVisites().clear();
	}

	public static void nextPatient() {

		if(Context.getInstance().getFileAttente().isEmpty()) 
		{
			System.out.println("Aucun patient dans la file d'attente");
		}
		else 
		{
			Medecin m = (Medecin)Context.getInstance().getConnected();

			Patient p = Context.getInstance().getFileAttente().poll();
			System.out.println(p);
			Visite v = new Visite(m, p);
			m.getVisites().add(v);

			if(m.getVisites().size()>=10)
			{
				saveVisites();
			}
		}

	}

	public static void main(String[] args) {
		menuPrincipal();

	}

}

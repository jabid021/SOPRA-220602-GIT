export class Personne {
	nom: string;
	prenom: string;
	
	constructor(nom?: string, prenom?: string) {
		this.nom = nom;
		this.prenom = prenom;
	}
}

export class Client extends Personne {
	ca: number;
	produits: Array<Produit> = new Array<Produit>();
	
	constructor(nom?: string, prenom?: string, ca?: number) {
		super(nom, prenom);
		this.ca = ca;
	}
}

export class Fournisseur extends Personne {
	constructor(nom?: string, prenom?: string, public societe?: string) {
		super(nom, prenom);
	}
}

export class Produit {
	nom: string;
	prix: number;
	fournisseur: Fournisseur;
	clients: Array<Client> = new Array<Client>();
	
	constructor(nom?: string, prix?: number, fournisseur?: Fournisseur) {
		this.nom = nom;
		this.prix = prix;
		this.fournisseur = fournisseur;
	}
}
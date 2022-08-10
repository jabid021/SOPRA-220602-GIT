export class Personne {
	id: number;
	nom: string;
	prenom: string;
	
	constructor(id?: number, nom?: string, prenom?: string) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
}

export class Client extends Personne {
	ca: number;
	produits: Array<Produit> = new Array<Produit>();
	
	constructor(id?: number, nom?: string, prenom?: string, ca?: number) {
		super(id, nom, prenom);
		this.ca = ca;
	}
}

export class Fournisseur extends Personne {
	constructor(id?: number, nom?: string, prenom?: string, public societe?: string) {
		super(id, nom, prenom);
	}
}

export class Produit {
	id: number;
	nom: string;
	prix: number;
	fournisseur: Fournisseur;
	clients: Array<Client> = new Array<Client>();
	
	constructor(id?: number, nom?: string, prix?: number, fournisseur?: Fournisseur) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.fournisseur = fournisseur;
	}
}
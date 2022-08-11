export abstract class Personne {
    id: number;
    nom: string;
    prenom: string;

    constructor(id?: number, nom? : string, prenom?: string) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }
}

export class Client extends Personne {
    age: number;
    email: string;
    commentaires: string;
    adresse: Adresse;

    constructor(id?: number, nom? : string, prenom?: string, age?: number, email?: string, commentaires?: string) {
        super(id, nom, prenom);
        this.age = age;
        this.email = email;
        this.commentaires = commentaires;
    }
}

export class Adresse {
    id: number;
    rue: string;
    codePostal: string;
    ville: string;

    constructor(id?: number, rue?: string, codePostal?: string, ville?: string) {
        this.id = id;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }
}
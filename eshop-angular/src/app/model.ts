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

    constructor(id?: number, nom? : string, prenom?: string, age?: number, email?: string, commentaires?: string) {
        super(id, nom, prenom);
        this.age = age;
        this.email = email;
        this.commentaires = commentaires;
    }
}
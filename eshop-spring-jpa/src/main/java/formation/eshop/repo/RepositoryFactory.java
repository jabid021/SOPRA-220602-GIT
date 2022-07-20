package formation.eshop.repo;

import formation.eshop.repo.jpa.FournisseurRepositoryJpa;
import formation.eshop.repo.jpa.ProduitRepositoryJpa;

// Responsable de la création de toutes les repositories
public class RepositoryFactory {
	
	// Créer la ProduitRepository ... en utilisant son interface (couplage faible)
	public static IProduitRepository creerProduitRepository() {
		return new ProduitRepositoryJpa();
	}
	
	public static IFournisseurRepository creerFournisseurRepository() {
		return new FournisseurRepositoryJpa();
	}
	
}

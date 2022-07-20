package formation.eshop.repo;

import java.util.List;

import formation.eshop.model.Produit;

public interface IProduitRepository extends IRepository<Produit, Long> {
	public List<Produit> findByPrixBetween(Double a, Double b);
}

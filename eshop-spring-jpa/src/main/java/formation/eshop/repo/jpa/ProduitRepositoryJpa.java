package formation.eshop.repo.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formation.eshop.model.Produit;
import formation.eshop.repo.IProduitRepository;

@Repository
@Transactional
public class ProduitRepositoryJpa implements IProduitRepository {

	@PersistenceContext
	private EntityManager em;

	public ProduitRepositoryJpa() {
	}

	@Override
	public List<Produit> findAll() {
		TypedQuery<Produit> query = em.createQuery("select p from Produit p", Produit.class);

		return query.getResultList();
	}

	@Override
	public Optional<Produit> findById(Long id) {
		Produit produit = null;

		produit = em.find(Produit.class, id);

		if (produit != null) {
			return Optional.of(produit);
		}
		
		return Optional.empty();
	}

	@Override
	public Produit save(Produit obj) {
		obj = em.merge(obj);

		return obj;
	}

	@Override
	public void deleteById(Long id) {
		em.remove(em.find(Produit.class, id));
	}

	@Override
	public List<Produit> findByPrixBetween(Double a, Double b) {
		TypedQuery<Produit> query = em.createQuery("select p from Produit p where p.prixVente between ?1 and ?2",
				Produit.class);
		query.setParameter(1, a);
		query.setParameter(2, b);

		return query.getResultList();
	}
}
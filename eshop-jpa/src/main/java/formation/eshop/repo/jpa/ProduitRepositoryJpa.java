package formation.eshop.repo.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formation.eshop.Singleton;
import formation.eshop.model.Produit;
import formation.eshop.repo.IProduitRepository;

public class ProduitRepositoryJpa implements IProduitRepository {
	public ProduitRepositoryJpa() {
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> produits = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Produit> query = em.createQuery("select p from Produit p", Produit.class);

			produits = query.getResultList();

			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return produits;
	}

	@Override
	public Optional<Produit> findById(Long id) {
		Produit produit = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			produit = em.find(Produit.class, id);

			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return Optional.of(produit);
	}

	@Override
	public Produit save(Produit obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			obj = em.merge(obj);

			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return obj;
	}

	@Override
	public void deleteById(Long id) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			em.remove(em.find(Produit.class, id));

			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public List<Produit> findByPrixBetween(Double a, Double b) {
		List<Produit> produits = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Produit> query = em.createQuery("select p from Produit p where p.prixVente between ?1 and ?2",
					Produit.class);
			query.setParameter(1, a);
			query.setParameter(2, b);

			produits = query.getResultList();

			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return produits;
	}
}
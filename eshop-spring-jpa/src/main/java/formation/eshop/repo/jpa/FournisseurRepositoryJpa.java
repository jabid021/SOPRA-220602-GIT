package formation.eshop.repo.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formation.eshop.model.Fournisseur;
import formation.eshop.repo.IFournisseurRepository;

@Repository
@Transactional
public class FournisseurRepositoryJpa implements IFournisseurRepository {

	@PersistenceContext
	private EntityManager em;

	public FournisseurRepositoryJpa() {
	}

	@Override
	public List<Fournisseur> findAll() {
		TypedQuery<Fournisseur> query = em.createQuery("select f from Fournisseur f", Fournisseur.class);

		return query.getResultList();
	}

	@Override
	public Optional<Fournisseur> findById(Long id) {
		Fournisseur fournisseur = null;

		fournisseur = em.find(Fournisseur.class, id);

		if (fournisseur != null) {
			return Optional.of(fournisseur);
		}

		return Optional.empty();
	}

	public Fournisseur save(Fournisseur obj) {
		obj = em.merge(obj);

		return obj;
	}

	public void deleteById(Long id) {
		em.remove(em.find(Fournisseur.class, id));
	}

}

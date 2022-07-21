package formation.eshop.repo.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formation.eshop.model.Adresse;
import formation.eshop.repo.IAdresseRepository;

@Repository
@Transactional
public class AdresseRepositoryJpa implements IAdresseRepository {

	@PersistenceContext
	private EntityManager em;

	public AdresseRepositoryJpa() {
	}

	@Override
	public List<Adresse> findAll() {
		TypedQuery<Adresse> query = em.createQuery("select a from Adresse a", Adresse.class);

		return query.getResultList();
	}

	@Override
	public Optional<Adresse> findById(Long id) {
		Adresse adresse = null;

		adresse = em.find(Adresse.class, id);

		if (adresse != null) {
			return Optional.of(adresse);
		}

		return Optional.empty();
	}

	public Adresse save(Adresse obj) {
		obj = em.merge(obj);

		return obj;
	}

	public void deleteById(Long id) {
		em.remove(em.find(Adresse.class, id));
	}

}

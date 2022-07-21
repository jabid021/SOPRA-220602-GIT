package formation.eshop.repo.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formation.eshop.model.Achat;
import formation.eshop.repo.IAchatRepository;

@Repository
@Transactional
public class AchatRepositoryJpa implements IAchatRepository {

	@PersistenceContext
	private EntityManager em;

	public AchatRepositoryJpa() {
	}

	@Override
	public List<Achat> findAll() {
		TypedQuery<Achat> query = em.createQuery("select a from Achat a", Achat.class);

		return query.getResultList();
	}

	@Override
	public Optional<Achat> findById(Long id) {
		Achat achat = null;

		achat = em.find(Achat.class, id);

		if (achat != null) {
			return Optional.of(achat);
		}

		return Optional.empty();
	}

	public Achat save(Achat obj) {
		obj = em.merge(obj);

		return obj;
	}

	public void deleteById(Long id) {
		em.remove(em.find(Achat.class, id));
	}

}

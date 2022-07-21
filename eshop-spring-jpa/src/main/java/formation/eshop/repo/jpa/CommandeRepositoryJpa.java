package formation.eshop.repo.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formation.eshop.model.Commande;
import formation.eshop.repo.ICommandeRepository;

@Repository
@Transactional
public class CommandeRepositoryJpa implements ICommandeRepository {

	@PersistenceContext
	private EntityManager em;

	public CommandeRepositoryJpa() {
	}

	@Override
	public List<Commande> findAll() {
		TypedQuery<Commande> query = em.createQuery("select c from Commande c", Commande.class);

		return query.getResultList();
	}

	@Override
	public Optional<Commande> findById(Long id) {
		Commande commande = null;

		commande = em.find(Commande.class, id);

		if (commande != null) {
			return Optional.of(commande);
		}

		return Optional.empty();
	}

	public Commande save(Commande obj) {
		obj = em.merge(obj);

		return obj;
	}

	public void deleteById(Long id) {
		em.remove(em.find(Commande.class, id));
	}

}

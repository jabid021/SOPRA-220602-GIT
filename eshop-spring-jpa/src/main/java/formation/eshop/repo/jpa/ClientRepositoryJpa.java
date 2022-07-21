package formation.eshop.repo.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formation.eshop.model.Client;
import formation.eshop.repo.IClientRepository;

@Repository
@Transactional
public class ClientRepositoryJpa implements IClientRepository {

	@PersistenceContext
	private EntityManager em;

	public ClientRepositoryJpa() {
	}

	@Override
	public List<Client> findAll() {
		TypedQuery<Client> query = em.createQuery("select c from Client c", Client.class);

		return query.getResultList();
	}

	@Override
	public Optional<Client> findById(Long id) {
		Client client = null;

		client = em.find(Client.class, id);

		if (client != null) {
			return Optional.of(client);
		}

		return Optional.empty();
	}

	public Client save(Client obj) {
		obj = em.merge(obj);

		return obj;
	}

	public void deleteById(Long id) {
		em.remove(em.find(Client.class, id));
	}

}

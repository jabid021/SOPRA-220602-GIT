package formation.eshop.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import formation.eshop.model.Commande;

public interface ICommandeRepository extends JpaRepository<Commande, Long> {
	@Query("select distinct c from Commande c left join fetch c.achats where c.id = ?1")
	Optional<Commande> findByIdWithAchats(Long id);
}

package formation.eshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.eshop.model.Commande;

public interface ICommandeRepository extends JpaRepository<Commande, Long> {

}

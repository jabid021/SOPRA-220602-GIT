package formation.eshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import formation.eshop.model.Fournisseur;

public interface IFournisseurRepository extends JpaRepository<Fournisseur, Long> {
	List<Fournisseur> findAllBySociete(@Param("societe") String societe); // par @NamedQuery
}

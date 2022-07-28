package formation.eshop.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.eshop.model.Fournisseur;

public interface IFournisseurRepository extends JpaRepository<Fournisseur, Long> {
	List<Fournisseur> findAllBySociete(@Param("societe") String societe); // par @NamedQuery

	@Query("select distinct f from Fournisseur f left join fetch f.produits where f.id = ?1")
	Optional<Fournisseur> findByIdWithProduits(Long id);
}

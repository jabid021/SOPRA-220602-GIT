package formation.eshop.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import formation.eshop.model.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Long> {
	@RestResource(path = "/by-libelle")
	List<Produit> findByLibelleStartingWith(String libelle); // convention de nommage
	
	@Query("select p from Produit p where p.prixVente between ?1 and ?2") 
	List<Produit> findByPrixBetween(Double a, Double b); // par annotation
	
	@Query("select p from Produit p where p.stock = :monStock")
	List<Produit> findByStock(@Param("monStock") int stock, Pageable pageable);
}

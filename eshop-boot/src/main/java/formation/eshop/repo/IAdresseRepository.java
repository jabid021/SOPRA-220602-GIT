package formation.eshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import formation.eshop.model.Adresse;

public interface IAdresseRepository extends JpaRepository<Adresse, Long> {
	@Query("select distinct a from Personne p right join p.adresse a where p is null")
	List<Adresse> findAllOrphan();
	
	
	
}

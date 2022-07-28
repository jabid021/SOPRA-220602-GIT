package formation.eshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.eshop.model.Achat;

public interface IAchatRepository extends JpaRepository<Achat, Long> {

}

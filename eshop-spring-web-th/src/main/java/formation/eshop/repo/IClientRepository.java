package formation.eshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.eshop.model.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {

}

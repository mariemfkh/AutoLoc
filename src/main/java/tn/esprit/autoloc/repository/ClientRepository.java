package tn.esprit.autoloc.repository;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>  {
}

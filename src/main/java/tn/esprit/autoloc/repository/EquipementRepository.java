package tn.esprit.autoloc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.entities.Equipement;
@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {
}

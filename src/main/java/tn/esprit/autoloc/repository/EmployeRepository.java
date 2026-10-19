package tn.esprit.autoloc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.entities.Employe;
@Repository
public interface EmployeRepository  extends JpaRepository<Employe, Long> {
}

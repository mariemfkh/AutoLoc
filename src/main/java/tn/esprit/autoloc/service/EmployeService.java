package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Employe;
import java.util.List;

public interface EmployeService {

    Employe create(Employe employe);

    Employe getById(Long id);

    List<Employe> getAll();

    Employe update(Long id, Employe employe);

    void delete(Long id);
}

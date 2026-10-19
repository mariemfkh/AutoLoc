package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Equipement;
import java.util.List;

public interface EquipementService {

    Equipement create(Equipement equipement);

    Equipement getById(Long id);

    List<Equipement> getAll();

    Equipement update(Long id, Equipement equipement);

    void delete(Long id);
}

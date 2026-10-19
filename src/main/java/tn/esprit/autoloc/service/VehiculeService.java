package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Vehicule;
import java.util.List;

public interface VehiculeService {

    Vehicule create(Vehicule vehicule);

    Vehicule getById(Long id);

    List<Vehicule> getAll();

    Vehicule update(Long id, Vehicule vehicule);

    void delete(Long id);
}

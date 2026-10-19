package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Contrat;
import java.util.List;
public interface ContratService {

    Contrat create(Contrat contrat);

    Contrat getById(Long id);

    List<Contrat> getAll();

    Contrat update(Long id, Contrat contrat);

    void delete(Long id);
}

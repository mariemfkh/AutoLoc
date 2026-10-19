package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Maintenance;
import java.util.List;

public interface MaintenanceService {

    Maintenance create(Maintenance maintenance);

    Maintenance getById(Long id);

    List<Maintenance> getAll();

    Maintenance update(Long id, Maintenance maintenance);

    void delete(Long id);
}

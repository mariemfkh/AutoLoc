package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.entities.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;
import tn.esprit.autoloc.service.MaintenanceService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance create(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    @Transactional(readOnly = true)
    public Maintenance getById(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maintenance introuvable avec l'id : " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Maintenance> getAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance update(Long id, Maintenance maintenance) {
        if (!maintenanceRepository.existsById(id)) {
            throw new RuntimeException("Maintenance introuvable avec l'id : " + id);
        }
        maintenance.setIdMaintenance(id);
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void delete(Long id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new RuntimeException("Maintenance introuvable avec l'id : " + id);
        }
        maintenanceRepository.deleteById(id);
    }
}

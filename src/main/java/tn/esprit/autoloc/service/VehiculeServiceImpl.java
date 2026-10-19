package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.entities.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;
import tn.esprit.autoloc.service.VehiculeService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class VehiculeServiceImpl implements VehiculeService {

    private final VehiculeRepository vehiculeRepository;
    @Override
    public Vehicule create(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional(readOnly = true)
    public Vehicule getById(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable avec l'id : " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicule> getAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule update(Long id, Vehicule vehicule) {
        if (!vehiculeRepository.existsById(id)) {
            throw new RuntimeException("Vehicule introuvable avec l'id : " + id);
        }
        vehicule.setIdVehicule(id);
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void delete(Long id) {
        if (!vehiculeRepository.existsById(id)) {
            throw new RuntimeException("Vehicule introuvable avec l'id : " + id);
        }
        vehiculeRepository.deleteById(id);
    }
}

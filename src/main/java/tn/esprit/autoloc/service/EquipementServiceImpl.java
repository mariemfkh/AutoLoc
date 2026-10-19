package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.entities.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.service.EquipementService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class EquipementServiceImpl implements EquipementService {

    private final EquipementRepository equipementRepository;

    @Override
    public Equipement create(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    @Transactional(readOnly = true)
    public Equipement getById(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipement introuvable avec l'id : " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Equipement> getAll() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement update(Long id, Equipement equipement) {
        if (!equipementRepository.existsById(id)) {
            throw new RuntimeException("Equipement introuvable avec l'id : " + id);
        }
        equipement.setIdEquipement(id);
        return equipementRepository.save(equipement);
    }

    @Override
    public void delete(Long id) {
        if (!equipementRepository.existsById(id)) {
            throw new RuntimeException("Equipement introuvable avec l'id : " + id);
        }
        equipementRepository.deleteById(id);
    }
}


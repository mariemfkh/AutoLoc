package tn.esprit.autoloc.service;
import lombok.AllArgsConstructor;
import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.service.AgenceService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
@AllArgsConstructor
public class AgenceServiceImpl implements AgenceService {

    private final AgenceRepository agenceRepository;
    @Override
    public Agence create(Agence agence) {
        return agenceRepository.save(agence);
    }
    @Override
    @Transactional(readOnly = true)
    public Agence getById(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agence introuvable avec l'id : " + id));
    }
    @Override
    @Transactional(readOnly = true)
    public List<Agence> getAll() {
        return agenceRepository.findAll();
    }
    @Override
    public Agence update(Long id, Agence agence) {
        if (!agenceRepository.existsById(id)) {
            throw new RuntimeException("Agence introuvable avec l'id : " + id);
        }
        agence.setIdAgence(id);
        return agenceRepository.save(agence);
    }
    @Override
    public void delete(Long id) {
        if (!agenceRepository.existsById(id)) {
            throw new RuntimeException("Agence introuvable avec l'id : " + id);
        }
        agenceRepository.deleteById(id);
    }
}


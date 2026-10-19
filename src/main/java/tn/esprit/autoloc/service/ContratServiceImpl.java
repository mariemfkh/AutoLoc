package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;
import tn.esprit.autoloc.service.ContratService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ContratServiceImpl implements ContratService {

    private final ContratRepository contratRepository;

    @Override
    public Contrat create(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    @Transactional(readOnly = true)
    public Contrat getById(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat introuvable avec l'id : " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contrat> getAll() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat update(Long id, Contrat contrat) {
        if (!contratRepository.existsById(id)) {
            throw new RuntimeException("Contrat introuvable avec l'id : " + id);
        }
        contrat.setIdContrat(id);
        return contratRepository.save(contrat);
    }

    @Override
    public void delete(Long id) {
        if (!contratRepository.existsById(id)) {
            throw new RuntimeException("Contrat introuvable avec l'id : " + id);
        }
        contratRepository.deleteById(id);
    }
}

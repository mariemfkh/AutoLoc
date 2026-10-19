package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.entities.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;
import tn.esprit.autoloc.service.PaiementService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository paiementRepository;

    @Override
    public Paiement create(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    @Transactional(readOnly = true)
    public Paiement getById(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement introuvable avec l'id : " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Paiement> getAll() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement update(Long id, Paiement paiement) {
        if (!paiementRepository.existsById(id)) {
            throw new RuntimeException("Paiement introuvable avec l'id : " + id);
        }
        paiement.setIdPaiement(id);
        return paiementRepository.save(paiement);
    }

    @Override
    public void delete(Long id) {
        if (!paiementRepository.existsById(id)) {
            throw new RuntimeException("Paiement introuvable avec l'id : " + id);
        }
        paiementRepository.deleteById(id);
    }
}

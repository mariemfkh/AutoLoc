package tn.esprit.autoloc.service;
import lombok.AllArgsConstructor;
import tn.esprit.autoloc.entities.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;
import tn.esprit.autoloc.service.EmployeService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
@AllArgsConstructor
public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository employeRepository;

    @Override
    public Employe create(Employe employe) {
        return employeRepository.save(employe);
    }
    @Override
    @Transactional(readOnly = true)
    public Employe getById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employe introuvable avec l'id : " + id));
    }
    @Override
    @Transactional(readOnly = true)
    public List<Employe> getAll() {
        return employeRepository.findAll();
    }
    @Override
    public Employe update(Long id, Employe employe) {
        if (!employeRepository.existsById(id)) {
            throw new RuntimeException("Employe introuvable avec l'id : " + id);
        }
        employe.setIdEmploye(id);
        return employeRepository.save(employe);
    }
    @Override
    public void delete(Long id) {
        if (!employeRepository.existsById(id)) {
            throw new RuntimeException("Employe introuvable avec l'id : " + id);
        }
        employeRepository.deleteById(id);
    }
}


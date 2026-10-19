package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.entities.Client;
import tn.esprit.autoloc.repository.ClientRepository;
import tn.esprit.autoloc.service.ClientService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client getById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable avec l'id : " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client update(Long id, Client client) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client introuvable avec l'id : " + id);
        }
        client.setIdClient(id);
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client introuvable avec l'id : " + id);
        }
        clientRepository.deleteById(id);
    }
}


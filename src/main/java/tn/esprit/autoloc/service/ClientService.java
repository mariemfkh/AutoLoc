package tn.esprit.autoloc.service;
import tn.esprit.autoloc.entities.Client;
import java.util.List;

public interface ClientService {

    Client create(Client client);

    Client getById(Long id);

    List<Client> getAll();

    Client update(Long id, Client client);

    void delete(Long id);
}

package procurations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procurations.model.Client;
import procurations.repository.ClientRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientService {
    // TODO client exists validation
    @Autowired
    ClientRepository clientRepository;

    public Client getClient(long clientId) {
        return Optional.ofNullable(clientRepository.getSingleClientById(clientId)).orElseThrow(() -> new NoSuchElementException("Client not found"));
    }
}

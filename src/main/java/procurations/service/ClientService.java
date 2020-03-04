package procurations.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procurations.model.Client;
import procurations.repository.ClientRepository;

@Service
public class ClientService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    // TODO client exists validation
    @Autowired
    ClientRepository clientRepository;

    // null if not exist
    public Client getClient(long clientId) {
        log.info("Get client with id {}", clientId);
        return clientRepository.getSingleClientById(clientId);
    }
}

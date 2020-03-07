package procurations.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procurations.exception.NotFoundException;
import procurations.model.Client;
import procurations.repository.client.ClientJdbcRepository;

@Service
public class ClientService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    ClientJdbcRepository clientJdbcRepository;

    public Client get(long clientId) {
        log.info("Get client with id {}", clientId);
        Client client = clientJdbcRepository.get(clientId);
        if (client == null) {
            log.info("Client with id {} not found", clientId);
            throw new NotFoundException("Client with id " + clientId + " not found");
        }
        return client;
    }
}

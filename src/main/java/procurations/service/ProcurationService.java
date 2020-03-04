package procurations.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procurations.exception.ClientNotFoundException;
import procurations.model.Client;
import procurations.model.Procuration;
import procurations.model.ProcurationDto;
import procurations.repository.ProcurationRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProcurationService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ProcurationRepository procurationRepository;
    @Autowired
    ClientService clientService;

    public ProcurationDto create(Procuration procuration) {
        log.info("Create procuration from {}", procuration);
        Client principalClient = Optional.ofNullable(clientService.getClient(procuration.getPrincipalClientId()))
                .orElseThrow(() -> {
                    log.info("Client with id {} not found", procuration.getPrincipalClientId());
                    return new ClientNotFoundException("Principal client not found");
                });
        Client attorneyClient = Optional.ofNullable(clientService.getClient(procuration.getAttorneyClientId()))
                .orElseThrow(() -> {
                    log.info("Client with id {} not found", procuration.getAttorneyClientId());
                    return new ClientNotFoundException("Attorney client not found");
                });

        ProcurationDto procurationDto = new ProcurationDto("Account procuration", 34, procuration.getState());
        // TODO convert to lombok builder ?
        procurationDto.setPrincipalClient(principalClient);
        procurationDto.setAttorneyClient(attorneyClient);
        procurationDto.setAccount(procuration.getAccount());
        procurationDto.setAction(11);
        procurationDto.setState(procuration.getState());
        return procurationRepository.insert(procurationDto);
    }

    public ProcurationDto get(int id) {
        log.info("Get procuration by id {}", id);
        return Optional.ofNullable(procurationRepository.getSingleProcurationById(id)).orElseThrow(NoSuchElementException::new);
    }
}

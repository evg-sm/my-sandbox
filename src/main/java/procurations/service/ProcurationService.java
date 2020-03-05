package procurations.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procurations.exception.NotFoundException;
import procurations.model.Client;
import procurations.model.ProcurationDto;
import procurations.model.Procuration;
import procurations.repository.procuration.ProcurationJdbcRepository;

import java.util.Optional;

@Service
public class ProcurationService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ProcurationJdbcRepository procurationJdbcRepository;
    @Autowired
    ClientService clientService;

    public Procuration create(ProcurationDto procurationDto) {
        log.info("Create procuration from {}", procurationDto);
        Client principalClient = Optional.ofNullable(clientService.getClient(procurationDto.getPrincipalClientId()))
                .orElseThrow(() -> {
                    log.info("Client with id {} not found", procurationDto.getPrincipalClientId());
                    return new NotFoundException("Principal client not found");
                });
        Client attorneyClient = Optional.ofNullable(clientService.getClient(procurationDto.getAttorneyClientId()))
                .orElseThrow(() -> {
                    log.info("Client with id {} not found", procurationDto.getAttorneyClientId());
                    return new NotFoundException("Attorney client not found");
                });

        Procuration procuration = new Procuration("Account procuration", 34, procurationDto.getState());
        // TODO convert to lombok builder ?
        procuration.setPrincipalClient(principalClient);
        procuration.setAttorneyClient(attorneyClient);
        procuration.setAccount(procurationDto.getAccount());
        procuration.setAction(11);
        procuration.setProcurationState(procurationDto.getState());
        return procurationJdbcRepository.save(procuration);
    }

    public Procuration get(int id) {
        log.info("Get procuration by id {}", id);
        return Optional.ofNullable(procurationJdbcRepository.get(id))
                .orElseThrow(() -> {
                    log.info("Client with id {} not found", id);
                    return new NotFoundException("Procuration not found");
                });
    }
}

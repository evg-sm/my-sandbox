package procurations.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procurations.exception.NotFoundException;
import procurations.model.Procuration;
import procurations.model.ProcurationDto;
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
        Procuration procuration = new Procuration("Account procuration", 34, procurationDto.getState());
        // TODO convert to lombok builder ?
        procuration.setPrincipalClient(clientService.get(procurationDto.getPrincipalClientId()));
        procuration.setAttorneyClient(clientService.get(procurationDto.getAttorneyClientId()));
        procuration.setAccount(procurationDto.getAccount());
        procuration.setAction(11);
        procuration.setProcurationState(procurationDto.getState());
        return procurationJdbcRepository.save(procuration);
    }

    public Procuration get(int id) {
        log.info("Get procuration by id {}", id);
        return Optional.ofNullable(procurationJdbcRepository.get(id))
                .orElseThrow(() -> {
                    log.info("Procuration with id {} not found", id);
                    return new NotFoundException("Procuration with id " + id + " not found");
                });
    }
}

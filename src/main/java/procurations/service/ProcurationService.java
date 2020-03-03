package procurations.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procurations.model.Procuration;
import procurations.model.ProcurationDto;
import procurations.repository.ClientRepository;
import procurations.repository.ProcurationRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProcurationService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ProcurationRepository procurationRepository;
    @Autowired
    ClientRepository clientRepository;

    public ProcurationDto create(Procuration procuration) {
        log.info("Create procuration from {}", procuration);
        ProcurationDto procurationDto = new ProcurationDto("Account procuration", procuration.getAction(), procuration.getState());
        // TODO add client validation
        // TODO convert to lombok builder
        procurationDto.setPrincipalClient(clientRepository.getSingleClientById(procuration.getPrincipalClientId()));
        procurationDto.setAttorneyClient(clientRepository.getSingleClientById(procuration.getAttorneyClientId()));
        procurationDto.setAccount(procuration.getAccount());
        procurationDto.setAction(procuration.getAction());
        procurationDto.setState(procuration.getState());
        return procurationRepository.insert(procurationDto);
    }

    public ProcurationDto get(int id) {
        log.info("Get procuration by id {}", id);
        return Optional.ofNullable(procurationRepository.getSingleProcurationById(id)).orElseThrow(NoSuchElementException::new);
    }
}

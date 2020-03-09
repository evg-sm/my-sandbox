package procurations.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procurations.exception.NotFoundException;
import procurations.model.Client;
import procurations.model.Procuration;
import procurations.model.ProcurationDto;
import procurations.repository.procuration.ProcurationJdbcRepository;
import procurations.util.ProcurationUtil;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Service
public class ProcurationService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ProcurationJdbcRepository procurationJdbcRepository;
    @Autowired
    ClientService clientService;

    public Procuration save(ProcurationDto procurationDto) {
        log.info("Create procuration from {}", procurationDto);

        Procuration procuration = new Procuration();
        Client principalClient = clientService.get(procurationDto.getPrincipalClientId());
        Client attorneyClient = clientService.get(procurationDto.getAttorneyClientId());

        procuration.setActions(procurationDto.getActions());
        procuration.setAccountId(1232323123); // TODO implement get account
        procuration.setFma("123213asdasdas23123123"); // TODO implement generate fma
        procuration.setPoaNumber(randomAlphabetic(10));
        procuration.setBranchRef(String.valueOf(principalClient.getBranchId()));
        procuration.setPrincipalCnum(principalClient.getClientId());
        procuration.setPrincipalFioRus(principalClient.getFirstName().concat(" ")
                .concat(principalClient.getMiddleName()).concat(" ")
                .concat(principalClient.getLastName()));
        procuration.setPrincipalFioEng(principalClient.getTranslitName());
        procuration.setPrincipalDocType("11"); // ???
        procuration.setPrincipalDocSer(principalClient.getPassSerie());
        procuration.setPrincipalDocNum(principalClient.getPassNum());
        procuration.setPrincipalDocIssuedBy(principalClient.getPassIssuer());
        procuration.setPrincipalDocIssuedDate(principalClient.getPassDate());

        procuration.setAttorneyPersonalTypeId(10); // ???
        procuration.setAttorneyCnum(attorneyClient.getClientId());
        procuration.setAttorneyFioRus(attorneyClient.getFirstName().concat(" ")
                .concat(attorneyClient.getMiddleName()).concat(" ")
                .concat(attorneyClient.getLastName()));
        procuration.setAttorneyFioEng(attorneyClient.getTranslitName());
        procuration.setAttorneyDocType("11"); // ???
        procuration.setAttorneyDocSer(attorneyClient.getPassSerie());
        procuration.setAttorneyDocNum(attorneyClient.getPassNum());
        procuration.setAttorneyDocIssuedBy(attorneyClient.getPassIssuer());
        procuration.setAttorneyDocIssuedDate(attorneyClient.getPassDate());
        procuration.setStatus(procurationDto.getState().getId());
        procuration.setIsAttorneyValid(1);
        ProcurationUtil.setDatesByState(procuration, procurationDto.getState());

        return procurationJdbcRepository.save(procuration);
    }

    public Procuration get(int id) {
        log.info("Get procuration by id {}", id);
        Procuration procuration = procurationJdbcRepository.get(id);
        if (procuration == null) {
            log.info("Procuration with id {} not found", id);
            throw new NotFoundException("Procuration with id " + id + " not found");
        }
        log.info("Received procuration {}", procuration);
        return procuration;
    }

    public void delete(int id) {
        log.info("Delete procuration with id {}", id);
        if (!procurationJdbcRepository.delete(id)) {
            log.info("Procuration with id {} not deleted", id);
            throw new NotFoundException("Procuration with id " + id + " not deleted");
        }
    }
}

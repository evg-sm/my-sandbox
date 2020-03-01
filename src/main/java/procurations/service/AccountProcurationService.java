package procurations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procurations.ProcurationsActions;
import procurations.dto.Procuration;
import procurations.dto.State;
import procurations.repository.ClientRepository;
import procurations.repository.ProcurationRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

@Service
public class AccountProcurationService implements ProcurationsActions {

    private Procuration procuration;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProcurationRepository procurationRepository;

    @Override
    public AccountProcurationService setType(String name, List<String> permisions, State state) {
        procuration = new Procuration(name, permisions, state);
        return this;
    }

    @Override
    public ProcurationsActions addPrincipalClient(int clientId) {
        procuration.setPrincipalClient(clientRepository.getSingleClientById(clientId));
        procuration.setAccount(new BigDecimal(randomNumeric(20)));
        return this;
    }

    @Override
    public ProcurationsActions addAtterneyClient(int clientId) {
        procuration.setAtterneyClient(clientRepository.getSingleClientById(clientId));
        return this;
    }

    @Override
    public Procuration getProcurationInstance() {
        return procuration;
    }

    @Override
    public ProcurationsActions store() {
        Procuration insertedEntity = procurationRepository.insert(procuration);
        procuration = insertedEntity;
        return this;
    }

    public Procuration getProcuration(int id) {
        return procurationRepository.getSingleProcurationById(id);
    }
}

package procurations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procurations.model.Actions;
import procurations.model.Procuration;
import procurations.model.State;
import procurations.repository.ClientRepository;
import procurations.repository.ProcurationRepository;

import java.math.BigDecimal;

@Service
public class AccountProcuration implements Creatable {

    private Procuration procuration;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProcurationRepository procurationRepository;

    @Override
    public Creatable setType() {
        procuration = new Procuration("Account procuration", Actions.ACCOUNT.getId(), State.OPEN);
        return this;
    }

    @Override
    public Creatable setPrincipalClient(int clientId) {
        procuration.setPrincipalClient(clientRepository.getSingleClientById(clientId));
        return this;
    }

    @Override
    public Creatable setRelationAccount(BigDecimal account) {
        procuration.setAccount(account);
        return this;
    }

    @Override
    public Creatable setAttorneyClient(int clientId) {
        procuration.setAtterneyClient(clientRepository.getSingleClientById(clientId));
        return this;
    }

    @Override
    public Procuration create() {
        return procurationRepository.insert(procuration);
    }
}

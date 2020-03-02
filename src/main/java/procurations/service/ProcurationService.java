package procurations.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procurations.model.Procuration;
import procurations.repository.ProcurationRepository;

import java.math.BigDecimal;

@Service
public class ProcurationService {
    @Autowired
    ProcurationRepository procurationRepository;
    @Autowired
    ProcurationFactory procurationFactory;

    public Procuration create(int type) {
        return procurationFactory
                .create(type)
                .setType()
                .setPrincipalClient(1)
                .setRelationAccount(new BigDecimal(RandomStringUtils.randomNumeric(20)))
                .setAttorneyClient(2)
                .create();
    }

    public Procuration get(int id) {
        return procurationRepository.getSingleProcurationById(id);
    }
}

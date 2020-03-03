package procurations.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procurations.model.Procuration;
import procurations.repository.ProcurationRepository;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProcurationService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ProcurationRepository procurationRepository;
    @Autowired
    ProcurationFactory procurationFactory;

    public Procuration create(int type) {
        log.info("Create procuration by type {}", type);
        return procurationFactory
                .create(type)
                .setType()
                .setPrincipalClient(1)
                .setRelationAccount(new BigDecimal(RandomStringUtils.randomNumeric(20)))
                .setAttorneyClient(2)
                .create();
    }

    public Procuration get(int id) {
        log.info("Get procuration by id {}", id);
        return Optional.ofNullable(procurationRepository.getSingleProcurationById(id)).orElseThrow(NoSuchElementException::new);
    }
}

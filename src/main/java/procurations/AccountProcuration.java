package procurations;

import org.springframework.stereotype.Service;
import procurations.dto.Client;
import procurations.dto.Procuration;
import procurations.dto.State;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

@Service
public class AccountProcuration implements ProcurationsActions {

    private Procuration procuration;

    @Override
    public AccountProcuration setType(String name, List<String> permisions, State state) {
        procuration = new Procuration(name, permisions, state);
        return this;
    }

    @Override
    public ProcurationsActions addPrincipalClient() {
        procuration.setPrincipalClient(
                Client.builder()
                        .id(parseInt(randomNumeric(3)))
                        .name(randomAlphabetic(10))
                        .build());
        procuration.setAccount(new BigDecimal(randomNumeric(20)));
        return this;
    }

    @Override
    public ProcurationsActions addAtterneyClient() {
        procuration.setAtterneyClient(
                Client.builder()
                        .id(parseInt(randomNumeric(3)))
                        .name(randomAlphabetic(10))
                        .build());
        return this;
    }

    @Override
    public Procuration create() {
        return procuration;
    }
}

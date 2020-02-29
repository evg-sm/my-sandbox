package procurations;

import org.apache.commons.lang3.RandomStringUtils;
import procurations.dto.Client;
import procurations.dto.Procuration;
import procurations.dto.ProcurationDto;

import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class AccountProcuration extends Procuration implements ProcurationsActions {
//    private ProcurationDto procurationDto;
//
//    private ProcurationDto getProcurationDto() {
//        if (procurationDto != null) {
//            return procurationDto;
//        } else {
//            return new ProcurationDto();
//        }
//    }

    @Override
    public ProcurationsActions addPrincipalClient() {
        procurationDto = getProcuration();
        getProcuration().setPrincipalClient(
                Client.builder()
                        .id(parseInt(randomNumeric(3)))
                        .name(RandomStringUtils.randomAlphabetic(10))
                        .build());
        return this;
    }

    @Override
    public ProcurationsActions addAtterneyClient() {
        procurationDto = getProcuration();
        procurationDto.setAtterneyClient(
                Client.builder()
                        .id(parseInt(randomNumeric(3)))
                        .name(RandomStringUtils.randomAlphabetic(10))
                        .build());
        return this;
    }

    @Override
    public ProcurationDto create() {
        return getProcuration();
    }
}

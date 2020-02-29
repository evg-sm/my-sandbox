package procurations;

import procurations.dto.Procuration;
import procurations.dto.ProcurationDto;

public interface ProcurationsActions {

    ProcurationsActions addPrincipalClient();

    ProcurationsActions addAtterneyClient();

    ProcurationDto create();
}

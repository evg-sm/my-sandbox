package procurations;

import procurations.dto.Procuration;
import procurations.dto.State;

import java.util.List;

public interface ProcurationsActions {

    ProcurationsActions setType(String name, List<String> permisions, State state);

    ProcurationsActions addPrincipalClient(int clientId);

    ProcurationsActions addAtterneyClient(int clientId);

    Procuration getProcurationInstance();

    ProcurationsActions store();
}

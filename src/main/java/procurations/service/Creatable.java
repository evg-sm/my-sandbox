package procurations.service;

import procurations.model.Procuration;

import java.math.BigDecimal;

public interface Creatable {

    Creatable setType();

    Creatable setPrincipalClient(int clientId);

    Creatable setRelationAccount(BigDecimal account);

    Creatable setAttorneyClient(int clientId);

    Procuration create();
}

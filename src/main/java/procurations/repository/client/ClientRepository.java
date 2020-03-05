package procurations.repository.client;

import procurations.model.Client;
import procurations.model.Procuration;

public interface ClientRepository {
    // null if not found
    Client get(long id);
}

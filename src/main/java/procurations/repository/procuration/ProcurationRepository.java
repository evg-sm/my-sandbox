package procurations.repository.procuration;

import procurations.model.Procuration;

public interface ProcurationRepository {
    // null if not found
    Procuration get(int id);

    Procuration save(Procuration procuration);

    // false if not found
    boolean delete(int id);
}

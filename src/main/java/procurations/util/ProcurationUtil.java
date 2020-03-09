package procurations.util;

import procurations.model.Procuration;
import procurations.model.ProcurationState;

import java.time.LocalDate;

import static procurations.model.ProcurationState.*;

public class ProcurationUtil {
    private static final long DAYS = 15L;
    private static final long YEAR = 1L;

    public static void setDatesByState(Procuration procuration, ProcurationState state) {
        procuration.setCreateDate(LocalDate.now().minusYears(YEAR).atStartOfDay());
        procuration.setStartDate(NOT_STARTED == state ? LocalDate.now().plusDays(DAYS) : LocalDate.now().minusYears(YEAR));
        procuration.setExpirationDate(EXPIRED == state ? LocalDate.now().minusDays(DAYS) : LocalDate.now().plusYears(YEAR));
        procuration.setCancelDate(CANCELLED == state ? LocalDate.now().minusDays(DAYS) : null);
        procuration.setDeleteDate(DELETED == state ? LocalDate.now().minusDays(DAYS) : null);
        procuration.setLastModified(LocalDate.now().atStartOfDay());
    }
}

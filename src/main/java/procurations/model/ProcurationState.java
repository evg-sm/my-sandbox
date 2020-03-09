package procurations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProcurationState {
    ACTIVE(1),
    DELETED(0),
    EXPIRED(2),
    CANCELLED(3),
    NOT_STARTED(4);

    int id;
}

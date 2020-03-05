package procurations.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProcurationsActions {
    ACCOUNT(95),
    CARD(99);

    private int id;
}

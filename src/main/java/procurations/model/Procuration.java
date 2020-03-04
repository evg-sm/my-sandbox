package procurations.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Procuration {
    @Id
    @Min(value = 1, message = "principalClientId is required")
    private long principalClientId;
    @Min(value = 1, message = "attorneyClientId is required")
    private int attorneyClientId;
    @NotNull(message = "account is required")
    private BigDecimal account;
    @NotNull(message = "actions is required")
    @ElementCollection
    private List<Integer> action;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "state is required")
    private State state;
}

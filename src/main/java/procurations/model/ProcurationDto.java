package procurations.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcurationDto {
    @Min(value = 1, message = "principalClientId is required")
    private long principalClientId;
    @Min(value = 1, message = "attorneyClientId is required")
    private int attorneyClientId;
    @NotNull(message = "account is required")
    private String account;
    @NotNull(message = "actions is required")
    private Set<Integer> actions;
    @NotNull(message = "state is required")
    private ProcurationState state;
}

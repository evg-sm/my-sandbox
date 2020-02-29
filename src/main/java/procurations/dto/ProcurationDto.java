package procurations.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcurationDto {
    private int id;
    private String name;
    private String state;
    private Client principalClient;
    private Client atterneyClient;
}

package procurations.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcurationDto {
    private int id;
    private String name;
    private String state;
    private List<String> permisions;
    private Client principalClient;
    private Client atterneyClient;
}

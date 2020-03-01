package procurations.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Procuration {
    public int id;
    public String name;
    public State state;
    public BigDecimal account;
    public List<String> permissions = new ArrayList<>();
    public Client principalClient;
    public Client atterneyClient;

    public Procuration(String name, List<String> permissions, State state) {
        this.name = name;
        this.permissions.addAll(permissions);
        this.state = state;
    }
}

package procurations.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Procuration {
    public int id;
    public String name;
    public State state;
    public BigDecimal account;
    public List<String> permisions = new ArrayList<>();
    public Client principalClient;
    public Client atterneyClient;

    public Procuration(String name, List<String> permisions, State state) {
        this.name = name;
        this.permisions.addAll(permisions);
        this.state = state;
    }
}

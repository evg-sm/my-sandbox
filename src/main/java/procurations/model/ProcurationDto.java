package procurations.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcurationDto {
    public int id;
    public String name;
    public State state;
    public BigDecimal account;
    public Integer action;
    public Client principalClient;
    public Client attorneyClient;

    public ProcurationDto(String name, Integer action, State state) {
        this.name = name;
        this.action = action;
        this.state = state;
    }
}

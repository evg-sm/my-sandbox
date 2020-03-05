package procurations.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Procuration {
    public int id;
    public String name;
    public ProcurationState procurationState;
    public BigDecimal account;
    public Integer action;
    public Client principalClient;
    public Client attorneyClient;

    public Procuration(String name, Integer action, ProcurationState procurationState) {
        this.name = name;
        this.action = action;
        this.procurationState = procurationState;
    }
}

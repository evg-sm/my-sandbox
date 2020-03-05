package procurations.repository.procuration;

import org.springframework.jdbc.core.RowMapper;
import procurations.model.Client;
import procurations.model.Procuration;
import procurations.model.ProcurationState;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcurationMapper implements RowMapper<Procuration> {
    public Procuration mapRow(ResultSet rs, int rowNum) throws SQLException {
        Procuration procuration = new Procuration();

        procuration.setId(rs.getInt("id"));
        procuration.setName(rs.getString("name"));
        procuration.setProcurationState(ProcurationState.valueOf(rs.getString("state")));
        procuration.setAccount(rs.getBigDecimal("account"));
        procuration.setAction(rs.getInt("action"));

        Client pClient = new Client();
        pClient.setClientId(rs.getInt("p_client_id"));
        pClient.setTranslitName(rs.getString("p_client_name"));
        procuration.setPrincipalClient(pClient);

        Client aClient = new Client();
        aClient.setClientId(rs.getInt("a_client_id"));
        aClient.setTranslitName(rs.getString("a_client_name"));
        procuration.setAttorneyClient(aClient);

        return procuration;
    }
}
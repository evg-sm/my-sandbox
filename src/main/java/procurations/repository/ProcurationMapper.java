package procurations.repository;

import org.springframework.jdbc.core.RowMapper;
import procurations.dto.Client;
import procurations.dto.Procuration;
import procurations.dto.State;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcurationMapper implements RowMapper<Procuration> {
    public Procuration mapRow(ResultSet rs, int rowNum) throws SQLException {
        Procuration procuration = new Procuration();

        procuration.setId(rs.getInt("id"));
        procuration.setName(rs.getString("name"));
        procuration.setState(State.valueOf(rs.getString("state")));
        procuration.setAccount(rs.getBigDecimal("account"));
        procuration.setPermissions(null);

        Client pClient = new Client();
        pClient.setId(rs.getInt("p_client_id"));
        pClient.setName(rs.getString("p_client_name"));
        procuration.setPrincipalClient(pClient);

        Client aClient = new Client();
        aClient.setId(rs.getInt("a_client_id"));
        aClient.setName(rs.getString("a_client_name"));
        procuration.setAtterneyClient(aClient);

        return procuration;
    }
}
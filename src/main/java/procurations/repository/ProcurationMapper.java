package procurations.repository;

import org.springframework.jdbc.core.RowMapper;
import procurations.model.Client;
import procurations.model.ProcurationDto;
import procurations.model.State;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcurationMapper implements RowMapper<ProcurationDto> {
    public ProcurationDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProcurationDto procurationDto = new ProcurationDto();

        procurationDto.setId(rs.getInt("id"));
        procurationDto.setName(rs.getString("name"));
        procurationDto.setState(State.valueOf(rs.getString("state")));
        procurationDto.setAccount(rs.getBigDecimal("account"));
        procurationDto.setAction(rs.getInt("action"));

        Client pClient = new Client();
        pClient.setClientId(rs.getInt("p_client_id"));
        pClient.setTranslitName(rs.getString("p_client_name"));
        procurationDto.setPrincipalClient(pClient);

        Client aClient = new Client();
        aClient.setClientId(rs.getInt("a_client_id"));
        aClient.setTranslitName(rs.getString("a_client_name"));
        procurationDto.setAttorneyClient(aClient);

        return procurationDto;
    }
}
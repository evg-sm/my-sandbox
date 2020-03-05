package procurations.repository.client;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import procurations.model.Client;

import java.util.List;

@Repository
public class ClientJdbcRepository implements ClientRepository {

    private static final RowMapper<Client> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Client.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ClientJdbcRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Client get(long clientId) {
        List<Client> meals = jdbcTemplate.query(
                "SELECT * FROM CLIENT WHERE CLIENT_ID = ?", ROW_MAPPER, clientId);
        return DataAccessUtils.singleResult(meals);
    }
}

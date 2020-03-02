package procurations.repository;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import procurations.model.Client;

import java.util.List;

@Repository
public class ClientRepository {

    private static final RowMapper<Client> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Client.class);

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ClientRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Client getSingleClientById(int id) {
        List<Client> meals = jdbcTemplate.query(
                "SELECT * FROM CLIENT WHERE ID = ?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(meals);
    }
}

package procurations.repository;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import procurations.model.Procuration;

import java.util.List;

@Repository
public class ProcurationRepository {

    private static final ProcurationMapper ROW_MAPPER = new ProcurationMapper();

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertProcuration;

    public ProcurationRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertProcuration = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("procuration")
                .usingGeneratedKeyColumns("id");
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Procuration insert(Procuration procuration) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", procuration.getId())
                .addValue("name", procuration.getName())
                .addValue("state", procuration.getState())
                .addValue("account", procuration.getAccount())
                .addValue("action", procuration.getAction())
                .addValue("p_client_id", procuration.getPrincipalClient().getId())
                .addValue("p_client_name", procuration.getPrincipalClient().getName())
                .addValue("a_client_id", procuration.getAtterneyClient().getId())
                .addValue("a_client_name", procuration.getAtterneyClient().getName());
        Number newId = insertProcuration.executeAndReturnKey(map);
        procuration.setId(newId.intValue());
        return procuration;
    }

    public Procuration getSingleProcurationById(int id) {
        List<Procuration> procurations = jdbcTemplate.query(
                "SELECT * FROM procuration WHERE ID = ?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(procurations);
    }
}

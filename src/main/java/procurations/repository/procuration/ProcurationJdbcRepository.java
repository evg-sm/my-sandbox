package procurations.repository.procuration;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import procurations.model.Procuration;

import java.util.List;

@Repository
public class ProcurationJdbcRepository implements ProcurationRepository {

    private static final ProcurationMapper ROW_MAPPER = new ProcurationMapper();

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertProcuration;

    public ProcurationJdbcRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertProcuration = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("procuration")
                .usingGeneratedKeyColumns("id");
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Procuration get(int id) {
        List<Procuration> procurations = jdbcTemplate.query(
                "SELECT * FROM procuration WHERE ID = ?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(procurations);
    }

    @Override
    public Procuration save(Procuration procuration) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", procuration.getId())
                .addValue("name", procuration.getName())
                .addValue("state", procuration.getProcurationState())
                .addValue("account", procuration.getAccount())
                .addValue("action", procuration.getAction())
                .addValue("p_client_id", procuration.getPrincipalClient().getClientId())
                .addValue("p_client_name", procuration.getPrincipalClient().getTranslitName())
                .addValue("a_client_id", procuration.getAttorneyClient().getClientId())
                .addValue("a_client_name", procuration.getAttorneyClient().getTranslitName());
        Number newId = insertProcuration.executeAndReturnKey(map);
        procuration.setId(newId.intValue());
        return procuration;
    }

    @Override
    public boolean delete(int id) {
        // TODO implement
        return false;
    }
}

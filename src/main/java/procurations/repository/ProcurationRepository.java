package procurations.repository;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import procurations.model.ProcurationDto;

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

    public ProcurationDto insert(ProcurationDto procurationDto) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", procurationDto.getId())
                .addValue("name", procurationDto.getName())
                .addValue("state", procurationDto.getState())
                .addValue("account", procurationDto.getAccount())
                .addValue("action", procurationDto.getAction())
                .addValue("p_client_id", procurationDto.getPrincipalClient().getClientId())
                .addValue("p_client_name", procurationDto.getPrincipalClient().getTranslitName())
                .addValue("a_client_id", procurationDto.getAttorneyClient().getClientId())
                .addValue("a_client_name", procurationDto.getAttorneyClient().getTranslitName());
        Number newId = insertProcuration.executeAndReturnKey(map);
        procurationDto.setId(newId.intValue());
        return procurationDto;
    }

    public ProcurationDto getSingleProcurationById(int id) {
        List<ProcurationDto> procurationDtos = jdbcTemplate.query(
                "SELECT * FROM procuration WHERE ID = ?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(procurationDtos);
    }
}

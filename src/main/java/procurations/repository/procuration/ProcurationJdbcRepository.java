package procurations.repository.procuration;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import procurations.model.Procuration;

import java.util.*;

@Repository
@Transactional(readOnly = true)
public class ProcurationJdbcRepository implements ProcurationRepository {

    private static final ProcurationMapper PROCURATION_MAPPER = new ProcurationMapper();

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final SimpleJdbcInsert insertProcuration;

    public ProcurationJdbcRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.insertProcuration = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("POA")
                .usingGeneratedKeyColumns("POA_ID");
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Procuration get(int id) {
        List<Procuration> procurations = jdbcTemplate.query(
                "SELECT DISTINCT pr.ACCOUNT_ID as ACCOUNT_ID, pr.FMA as FMA, poa.* " +
                        "FROM POA poa JOIN PROCURATION pr ON poa.POA_ID = pr.POA_ID WHERE poa.POA_ID = ?", PROCURATION_MAPPER, id);
        return setActions(DataAccessUtils.singleResult(procurations));
    }

    private Procuration setActions(Procuration procuration) {
        if (procuration != null) {
            List<Integer> actions = jdbcTemplate.queryForList("SELECT ACTION_ID FROM PROCURATION WHERE POA_ID=?", Integer.class, procuration.getPoaId());
            procuration.setActions(!CollectionUtils.isEmpty(actions) ? new HashSet<>(actions) : null);
        }
        return procuration;
    }

    @Override
    @Transactional
    public Procuration save(Procuration procuration) {
        MapSqlParameterSource poa = new MapSqlParameterSource()
                .addValue("POA_NUMBER", procuration.getPoaNumber())
                .addValue("POA_TYPE_ID", procuration.getPoaTypeId())
                .addValue("BRANCH_REF", procuration.getBranchRef())
                .addValue("PRINCIPAL_CNUM", procuration.getPrincipalCnum())
                .addValue("PRINCIPAL_FIO_RUS", procuration.getPrincipalFioRus())
                .addValue("PRINCIPAL_FIO_ENG", procuration.getPrincipalFioEng())
                .addValue("PRINCIPAL_DOCTYPE", procuration.getPrincipalDocType())
                .addValue("PRINCIPAL_DOC_SER", procuration.getPrincipalDocSer())
                .addValue("PRINCIPAL_DOC_NUM", procuration.getPrincipalDocNum())
                .addValue("PRINCIPAL_DOC_ISSUEDBY", procuration.getPrincipalDocIssuedBy())
                .addValue("PRINCIPAL_DOC_ISSUEDDATE", procuration.getPrincipalDocIssuedDate())
                .addValue("ATTORNEY_PERSON_TYPE_ID", procuration.getAttorneyPersonalTypeId())
                .addValue("ATTORNEY_CNUM", procuration.getAttorneyCnum())
                .addValue("ATTORNEY_FIO_RUS", procuration.getAttorneyFioRus())
                .addValue("ATTORNEY_FIO_ENG", procuration.getAttorneyFioEng())
                .addValue("ATTORNEY_DOCTYPE", procuration.getAttorneyDocType())
                .addValue("ATTORNEY_DOC_SER", procuration.getAttorneyDocSer())
                .addValue("ATTORNEY_DOC_NUM", procuration.getAttorneyDocNum())
                .addValue("ATTORNEY_DOC_ISSUEDBY", procuration.getAttorneyDocIssuedBy())
                .addValue("ATTORNEY_DOC_ISSUEDDATE", procuration.getAttorneyDocIssuedDate())
                .addValue("CREATE_DATE", procuration.getCreateDate())
                .addValue("START_DATE", procuration.getStartDate())
                .addValue("EXPIRATION_DATE", procuration.getExpirationDate())
                .addValue("CANCEL_DATE", procuration.getCancelDate())
                .addValue("DELETE_DATE", procuration.getDeleteDate())
                .addValue("VALIDITY_PERIOD_Y", procuration.getValidityPeiodY())
                .addValue("VALIDITY_PERIOD_M", procuration.getValidityPeiodM())
                .addValue("VALIDITY_PERIOD_D", procuration.getValidityPeiodD())
                .addValue("STATUS", procuration.getStatus())
                .addValue("LASTMODIFIED", procuration.getLastModified())
                .addValue("IS_ATTORNEY_VALID", procuration.getIsAttorneyValid());
        Number newId = insertProcuration.executeAndReturnKey(poa);
        procuration.setPoaId(newId.intValue());
        insertProcuration(procuration);

        return procuration;
    }

    private void insertProcuration(Procuration procuration) {
        Set<Integer> actions = procuration.getActions();
        if (!CollectionUtils.isEmpty(actions)) {
            jdbcTemplate.batchUpdate("INSERT INTO PROCURATION (ATTORNEY_CNUM, ACTION_ID, ACCOUNT_ID, FMA, POA_ID) VALUES (?, ?, ?, ?, ?)", actions, actions.size(),
                    (ps, action) -> {
                        ps.setInt(1, procuration.getAttorneyCnum());
                        ps.setInt(2, action);
                        ps.setInt(3, procuration.getAccountId());
                        ps.setString(4, procuration.getFma());
                        ps.setInt(5, procuration.getPoaId());
                    });
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        // TODO implement
        return false;
    }
}

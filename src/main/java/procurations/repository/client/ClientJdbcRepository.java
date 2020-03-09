package procurations.repository.client;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import procurations.model.Client;

import java.util.List;

@Repository
public class ClientJdbcRepository implements ClientRepository {

    private static final ClientMapper CLIENT_MAPPER = new ClientMapper();

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ClientJdbcRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Client get(long clientId) {
        List<Client> clients = jdbcTemplate.query(
                "SELECT CLIENT_ID, BRANCH_ID, EMPLOYER_ID, CATEGORY_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, TRANSLIT_NAME, DOB, POB, EMAIL, HAS_EMAIL_SUBSCRIPTION, LEGAL_ADDRESS, INN, PHONE, MOBILE_PHONE,\n" +
                        " PASS_SERIE, PASS_NUM, PASS_ISSUER, PASS_DATE, RESIDENT, LASTMODIFIED, REGION_CODE, BUNDLE_CODE, IS_COMPLIANCE, IS_PEP, CURRENT_ADDRESS FROM CLIENT WHERE CLIENT_ID = ?", CLIENT_MAPPER, clientId);
        return DataAccessUtils.singleResult(clients);
    }
}

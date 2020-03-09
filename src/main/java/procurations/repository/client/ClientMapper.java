package procurations.repository.client;

import org.springframework.jdbc.core.RowMapper;
import procurations.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ClientMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {

        Client client = new Client();
        client.setClientId(rs.getInt("CLIENT_ID"));
        client.setBranchId(rs.getInt("BRANCH_ID"));
        client.setEmployerId(rs.getInt("EMPLOYER_ID"));
        client.setCategoryId(rs.getInt("CATEGORY_ID"));
        client.setFirstName(rs.getString("FIRST_NAME"));
        client.setMiddleName(rs.getString("MIDDLE_NAME"));
        client.setLastName(rs.getString("LAST_NAME"));
        client.setTranslitName(rs.getString("TRANSLIT_NAME"));
        client.setDob(LocalDate.parse((rs.getString("DOB"))));
        client.setPob(rs.getString("POB"));
        client.setEmail(rs.getString("EMAIL"));
        client.setHasEmailSubscription(rs.getString("HAS_EMAIL_SUBSCRIPTION"));
        client.setLegalAddress(rs.getString("LEGAL_ADDRESS"));
        client.setInn(rs.getString("INN"));
        client.setPhone(rs.getString("PHONE"));
        client.setMobilePhone(rs.getString("MOBILE_PHONE"));
        client.setPassSerie(rs.getString("PASS_SERIE"));
        client.setPassNum(rs.getString("PASS_NUM"));
        client.setPassIssuer(rs.getString("PASS_ISSUER"));
        client.setPassDate(LocalDate.parse(rs.getString("PASS_DATE")));
        client.setResident("Y".equals(rs.getString("RESIDENT")));
        client.setLastModified(rs.getTimestamp("LASTMODIFIED").toLocalDateTime());
        client.setRegionCode(rs.getInt("REGION_CODE"));
        client.setBundleCode(rs.getString("BUNDLE_CODE"));
        client.setCompliance("1".equals(rs.getString("IS_COMPLIANCE")));
        client.setPep("1".equals(rs.getString("IS_PEP")));
        client.setCurrentAddress(rs.getString("CURRENT_ADDRESS"));

        return client;
    }
}

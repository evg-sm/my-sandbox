package procurations.repository.procuration;

import org.springframework.jdbc.core.RowMapper;
import procurations.model.Procuration;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcurationMapper implements RowMapper<Procuration> {
    public Procuration mapRow(ResultSet rs, int rowNum) throws SQLException {
        Procuration procuration = new Procuration();

        procuration.setPoaId(rs.getInt("POA_ID"));
        procuration.setAccountId(rs.getInt("ACCOUNT_ID"));
        procuration.setFma(rs.getString("FMA"));
        procuration.setPoaNumber(rs.getString("POA_NUMBER"));
        procuration.setPoaTypeId(rs.getInt("POA_TYPE_ID"));
        procuration.setBranchRef(rs.getString("BRANCH_REF"));

        procuration.setPrincipalCnum(rs.getInt("PRINCIPAL_CNUM"));
        procuration.setPrincipalFioRus(rs.getString("PRINCIPAL_FIO_RUS"));
        procuration.setPrincipalFioEng(rs.getString("PRINCIPAL_FIO_ENG"));
        procuration.setPrincipalDocType(rs.getString("PRINCIPAL_DOCTYPE"));
        procuration.setPrincipalDocSer(rs.getString("PRINCIPAL_DOC_SER"));
        procuration.setPrincipalDocNum(rs.getString("PRINCIPAL_DOC_NUM"));
        procuration.setPrincipalDocIssuedBy(rs.getString("PRINCIPAL_DOC_ISSUEDBY"));
        procuration.setPrincipalDocIssuedDate(rs.getDate("PRINCIPAL_DOC_ISSUEDDATE").toLocalDate());

        procuration.setAttorneyPersonalTypeId(rs.getInt("ATTORNEY_PERSON_TYPE_ID"));
        procuration.setAttorneyCnum(rs.getInt("ATTORNEY_CNUM"));
        procuration.setAttorneyFioRus(rs.getString("ATTORNEY_FIO_RUS"));
        procuration.setAttorneyFioEng(rs.getString("ATTORNEY_FIO_ENG"));
        procuration.setAttorneyDocType(rs.getString("ATTORNEY_DOCTYPE"));
        procuration.setAttorneyDocSer(rs.getString("ATTORNEY_DOC_SER"));
        procuration.setAttorneyDocNum(rs.getString("ATTORNEY_DOC_NUM"));
        procuration.setAttorneyDocIssuedBy(rs.getString("ATTORNEY_DOC_ISSUEDBY"));
        procuration.setAttorneyDocIssuedDate(rs.getDate("ATTORNEY_DOC_ISSUEDDATE").toLocalDate());

        procuration.setCreateDate(rs.getTimestamp("CREATE_DATE").toLocalDateTime());
        procuration.setStartDate(rs.getDate("START_DATE").toLocalDate());
        procuration.setExpirationDate(rs.getDate("EXPIRATION_DATE") != null ? rs.getDate("EXPIRATION_DATE").toLocalDate() : null);
        procuration.setCancelDate(rs.getDate("CANCEL_DATE") != null ? rs.getDate("CANCEL_DATE").toLocalDate() : null);
        procuration.setDeleteDate(rs.getDate("DELETE_DATE") != null ? rs.getDate("DELETE_DATE").toLocalDate() : null);
        procuration.setValidityPeiodY(rs.getInt("VALIDITY_PERIOD_Y"));
        procuration.setValidityPeiodM(rs.getInt("VALIDITY_PERIOD_M"));
        procuration.setValidityPeiodD(rs.getInt("VALIDITY_PERIOD_D"));
        procuration.setStatus(rs.getInt("STATUS"));
        procuration.setLastModified(rs.getDate("LASTMODIFIED") != null ? rs.getTimestamp("LASTMODIFIED").toLocalDateTime() : null);
        procuration.setIsAttorneyValid(rs.getInt("IS_ATTORNEY_VALID"));
        return procuration;
    }
}
package procurations.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Procuration {
    private int poaId;
    private Set<Integer> actions;
    private int accountId;
    private String fma;
    private String poaNumber;
    private int poaTypeId;
    private String branchRef;
    private int principalCnum;
    private String principalFioRus;
    private String principalFioEng;
    private String principalDocType;
    private String principalDocSer;
    private String principalDocNum;
    private String principalDocIssuedBy;
    private LocalDate principalDocIssuedDate;
    private int attorneyPersonalTypeId;
    private int attorneyCnum;
    private String attorneyFioRus;
    private String attorneyFioEng;
    private String attorneyDocType;
    private String attorneyDocSer;
    private String attorneyDocNum;
    private String attorneyDocIssuedBy;
    private LocalDate attorneyDocIssuedDate;
    private LocalDateTime createDate;
    private LocalDate startDate;
    private LocalDate expirationDate;
    private LocalDate cancelDate;
    private LocalDate deleteDate;
    private int ValidityPeiodY;
    private int ValidityPeiodM;
    private int ValidityPeiodD;
    private int status;
    private LocalDateTime lastModified;
    private int isAttorneyValid;
}

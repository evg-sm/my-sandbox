package procurations.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private int clientId;
    private int branchId;
    private int employerId;
    private int categoryId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String translitName;
    private LocalDate dob;
    private String pob;
    private String email;
    private String hasEmailSubscription;
    private String legalAddress;
    private String inn;
    private String phone;
    private String mobilePhone;
    private String passSerie;
    private String passNum;
    private String passIsuer;
    private LocalDate passDate;
    private boolean resident;
    private LocalDateTime lastModified;
    private int regionCode;
    private String bundleCode;
    private boolean isCompliance;
    private boolean isPep;
    private String currentAddress;
}

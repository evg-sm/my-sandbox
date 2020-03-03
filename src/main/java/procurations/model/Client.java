package procurations.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private int clientId;
    private int branchId;
    private int categoryId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String translitName;
    private LocalDate dob;
    private String pob;
    private String email;
    private String legalAddress;
    private String phone;
}

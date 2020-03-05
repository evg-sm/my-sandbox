package procurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import procurations.model.Client;
import procurations.model.ProcurationDto;
import procurations.model.Procuration;
import procurations.model.State;
import procurations.service.ProcurationService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ProcurationServiceTest {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ProcurationService procurationService;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createProcurationTest() {
        log.info("##### test result ######");
        Procuration expectedProcuration = Procuration.builder()
                .id(1)
                .name("Account procuration")
                .state(State.OPEN)
                .action(95)
                .principalClient(Client.builder()
                        .clientId(1)
                        .branchId(200)
                        .categoryId(70)
                        .firstName("Koji")
                        .middleName("K")
                        .lastName("Fokusima")
                        .translitName("Koji K Fokusima")
                        .dob(LocalDate.of(1980, 5, 30))
                        .pob("Fokusima")
                        .email("1@mail.ru")
                        .legalAddress("address1")
                        .phone("926-000-00-01")
                        .build())
                .attorneyClient(Client.builder()
                        .clientId(2)
                        .branchId(200)
                        .categoryId(50)
                        .firstName("Billy")
                        .middleName("F")
                        .lastName("Smith")
                        .translitName("Billy F Smith")
                        .dob(LocalDate.of(2000, 5, 30))
                        .pob("New York")
                        .email("2@mail.ru")
                        .legalAddress("address2")
                        .phone("926-000-00-02")
                        .build())
                .build();
        log.info("Expected procuration is {}", expectedProcuration);
//        ProcurationDto actualProcurationDto = procurationService.create(95);
//        log.info("Created procuration is {}", actualProcurationDto);
//        assertMatch(actualProcurationDto, expectedProcurationDto);
        log.info("##### test result ######");
    }

    @Test
    public void notFoundTest() {
        assertThrows(NoSuchElementException.class, () -> procurationService.get(-1));
    }

    @Test
    @SneakyThrows
    public void serialize() {
        ProcurationDto procurationDto = ProcurationDto.builder()
                .principalClientId(11111)
                .attorneyClientId(22222222)
                .account(new BigDecimal("123123123213123123"))
                .state(State.OPEN)
                .action(Collections.singletonList(11))
                .build();
        log.info(objectMapper.writeValueAsString(procurationDto));
    }
}

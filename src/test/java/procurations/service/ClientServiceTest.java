package procurations.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import procurations.exception.NotFoundException;
import procurations.model.Client;

import java.time.LocalDate;
import java.time.Month;

import static java.time.LocalDateTime.of;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static procurations.Matcher.ClientMatcher.assertMatch;

@SpringBootTest
class ClientServiceTest {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ClientService clientService;

    @Test
    void get() {
        Client expectedClient = Client.builder()
                .clientId(2)
                .branchId(200)
                .employerId(0)
                .categoryId(60)
                .firstName("Petr")
                .middleName("Spiridonovish")
                .lastName("Petryshev")
                .translitName("Pedrichev Petr Spiridonovish")
                .dob(LocalDate.of(1990, 06, 06))
                .pob("Moskow")
                .email("some_new@mail.ru")
                .hasEmailSubscription("N")
                .legalAddress("address 2")
                .phone("+7-926-000-00-01")
                .mobilePhone("+7-926-000-00-01")
                .passSerie("XXX")
                .passNum("XXXXXX")
                .passIsuer("YYYYYYYYYY")
                .passDate(LocalDate.of(2000, 05, 30))
                .resident(true)
                .lastModified(of(2020, Month.JANUARY, 30, 10, 00))
                .regionCode(77)
                .currentAddress("current")
                .isPep(false)
                .inn("89777000")
                .isCompliance(false)
                .build();

        Client actualClient = clientService.get(2);
        log.info("Actual client    {}", actualClient);
        log.info("Excpected client {}", expectedClient);

        assertMatch(actualClient, expectedClient);
    }

    @Test
    public void notFoundTest() {
        assertThrows(NotFoundException.class, () -> clientService.get(-1));
    }
}
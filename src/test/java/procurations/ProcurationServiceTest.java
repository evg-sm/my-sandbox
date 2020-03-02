package procurations;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import procurations.model.Client;
import procurations.model.Procuration;
import procurations.model.State;
import procurations.service.ProcurationService;

import static procurations.Matcher.ProcurationMatcher.assertMatch;

@SpringBootTest
public class ProcurationServiceTest {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ProcurationService procurationService;

    @Test
    public void createProcurationTest() {
        log.info("##### test result ######");
        Procuration expectedProcuration = Procuration.builder()
                .id(1)
                .name("Account procuration")
                .state(State.OPEN)
                .action(95)
                .principalClient(Client.builder().id(1).name("Koji").build())
                .atterneyClient(Client.builder().id(2).name("Billy").build())
                .build();
        log.info("Expected procuration is {}", expectedProcuration);
        Procuration actualProcuration = procurationService.create(95);
        log.info("Created procuration is {}", actualProcuration);
        assertMatch(actualProcuration, expectedProcuration);
        log.info("##### test result ######");
    }
}

package procurations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import procurations.dto.Procuration;
import procurations.dto.State;
import procurations.service.AccountProcurationService;

import java.util.Collections;

import static procurations.ProcurationMatcher.assertMatch;

@SpringBootTest
public class AccountProcurationServiceTest {

    @Autowired
    AccountProcurationService accountProcurationService;

    @Test
    public void createProcurationTest() {
        System.out.println("\n");

        Procuration procuration = accountProcurationService.setType("account", Collections.singletonList("98"), State.OPEN).addPrincipalClient(2).addAtterneyClient(5).getProcurationInstance();
        System.out.println("procurations is " + procuration);

        System.out.println("\n");
    }

    @Test
    public void createAndInsertProcuration() {
        Procuration procuration = accountProcurationService
                .setType("account", Collections.singletonList("98"), State.OPEN)
                .addPrincipalClient(2)
                .addAtterneyClient(5)
                .store()
                .getProcurationInstance();
        System.out.println("build procuration is  " + procuration);

        Procuration fromDb = accountProcurationService.getProcuration(procuration.getId());

        System.out.println("prociration from db is " + fromDb);

        assertMatch(procuration, fromDb);
    }
}

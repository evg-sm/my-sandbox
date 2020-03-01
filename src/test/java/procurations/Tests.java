package procurations;

import org.junit.jupiter.api.Test;
import procurations.dto.Procuration;
import procurations.dto.State;

import java.util.Collections;

public class Tests {

    @Test
    public void test01() {
        System.out.println("\n");

        ProcurationsActions actions = new AccountProcuration();
        Procuration procuration = actions.setType("account", Collections.singletonList("98"), State.OPEN).addPrincipalClient().addAtterneyClient().create();
        System.out.println("procurations is " + procuration);

        System.out.println("\n");
    }


}

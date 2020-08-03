package procurations;

import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void test01() {
        System.out.println("\n");

        ProcurationsActions actions = new AccountProcuration();
        System.out.println("procurations is " + actions.addPrincipalClient().addAtterneyClient().create());

        System.out.println("\n");
    }

    @Test
    public void test02() {
        System.out.println("\n");

        ProcurationsActions actions = new AccountProcuration();
        System.out.println("procurations is " + actions.addPrincipalClient().addAtterneyClient().create());

        System.out.println("\n");
    }

    @Test
    public void test03() {
        System.out.println("\n");

        ProcurationsActions actions = new AccountProcuration();
        System.out.println("procurations is " + actions.addPrincipalClient().addAtterneyClient().create());

        System.out.println("\n");
    }

}

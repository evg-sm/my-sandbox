package procurations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static procurations.model.Actions.ACCOUNT;

@Component
public class ProcurationFactory {

    @Autowired
    AccountProcuration accountProcuration;

    public Creatable create(int type) {
        if (ACCOUNT.getId() == type) {
            return accountProcuration;
        } else {
            throw new IllegalArgumentException();
        }
    }
}

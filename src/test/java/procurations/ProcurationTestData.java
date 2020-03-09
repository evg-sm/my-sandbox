package procurations;

import procurations.model.Procuration;
import procurations.model.ProcurationDto;
import procurations.model.ProcurationState;
import procurations.util.ProcurationUtil;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class ProcurationTestData {

    private static final Set<Integer> ACTIONS = new HashSet<>(Arrays.asList(11, 22));

    public static ProcurationDto getProcurationDto(ProcurationState state) {
        return ProcurationDto.builder()
                .principalClientId(1)
                .attorneyClientId(2)
                .account("13123123213123123")
                .actions(ACTIONS)
                .state(state)
                .build();
    }

    public static Procuration getProcuration(ProcurationState state) {
        Procuration expected = Procuration.builder()
                .poaId(1)
                .actions(ACTIONS)
                .accountId(1232323123)
                .fma("123213asdasdas23123123")
                .poaNumber(randomAlphabetic(10))
                .branchRef("200")
                .principalCnum(1)
                .principalFioRus("Ivan Ivanovich Petrov")
                .principalFioEng("Petrov Ivan Ivanych")
                .principalDocType("11")
                .principalDocSer("XXX")
                .principalDocNum("XXXXXX")
                .principalDocIssuedBy("YYYYYYYYYY")
                .principalDocIssuedDate(LocalDate.of(2000, 5, 30))
                .attorneyPersonalTypeId(10)
                .attorneyCnum(2)
                .attorneyFioRus("Petr Spiridonovish Petryshev")
                .attorneyFioEng("Pedrichev Petr Spiridonovish")
                .attorneyDocType("11")
                .attorneyDocSer("XXX")
                .attorneyDocNum("XXXXXX")
                .attorneyDocIssuedBy("YYYYYYYYYY")
                .attorneyDocIssuedDate(LocalDate.of(2000, 5, 30))
                .status(state.getId())
                .isAttorneyValid(1)
                .build();
        ProcurationUtil.setDatesByState(expected, state);
        return expected;
    }
}

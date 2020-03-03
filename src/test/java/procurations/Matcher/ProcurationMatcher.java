package procurations.Matcher;

import procurations.model.ProcurationDto;

import static org.assertj.core.api.Assertions.assertThat;

public class ProcurationMatcher {

    public static void assertMatch(ProcurationDto actual, ProcurationDto expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "account");
    }
}

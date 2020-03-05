package procurations.Matcher;

import procurations.model.Procuration;

import static org.assertj.core.api.Assertions.assertThat;

public class ProcurationMatcher {

    public static void assertMatch(Procuration actual, Procuration expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "account");
    }
}

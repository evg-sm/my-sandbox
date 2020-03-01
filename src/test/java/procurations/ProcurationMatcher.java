package procurations;

import procurations.dto.Procuration;

import static org.assertj.core.api.Assertions.assertThat;

public class ProcurationMatcher {

    public static void assertMatch(Procuration actual, Procuration expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "permissions");
    }
}

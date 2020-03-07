package procurations.Matcher;

import procurations.model.Client;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientMatcher {

    public static void assertMatch(Client actual, Client expected) {
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }
}

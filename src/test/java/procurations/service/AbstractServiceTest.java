package procurations.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

@SpringBootTest
@PropertySource("application-test.properties")
@Sql(scripts = "classpath:inintAndPopulateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class AbstractServiceTest {
    public final Logger log = LoggerFactory.getLogger(getClass());
}

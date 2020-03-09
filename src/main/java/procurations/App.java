package procurations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        // TODO test app with docker db2
        // TODO make in memory db only for tests
        SpringApplication.run(App.class, args);
    }
}

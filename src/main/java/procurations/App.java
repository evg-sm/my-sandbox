package procurations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        // TODO db current structure
        // TODO procuration repository save
        // TODO test app with docker db2
        // TODO make in memory db only for tests
        // TODO generic interface ???
        // TODO transactional
        SpringApplication.run(App.class, args);
    }
}

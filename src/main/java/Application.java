import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by Aditya.
 */

@SpringBootApplication
@EnableJpaRepositories
@EnableMongoRepositories
@EntityScan("com.coviam.model")
@ContextConfiguration(value = "com.coviam.config")
@ComponentScan(value = "com.coviam")
public class Application {
    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }
}

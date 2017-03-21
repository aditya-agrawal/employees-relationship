import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Aditya.
 */

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "com.coviam.model")
@ComponentScan(value = "com.coviam")
public class Application {
    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }
}

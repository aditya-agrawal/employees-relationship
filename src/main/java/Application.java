import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Aditya.
 */

@SpringBootApplication
@ComponentScan(value = "com.coviam")
public class Application {
    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }
}

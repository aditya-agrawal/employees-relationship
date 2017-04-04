import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * Created by Aditya.
 */

@SpringBootApplication
@EnableSolrRepositories
@ComponentScan(value = "com.coviam")
public class Application {
    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }
}

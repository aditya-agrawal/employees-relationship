import com.coviam.config.JpaConfig;
import com.coviam.config.MongoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by Aditya.
 */
@EnableCaching
@EnableRedisRepositories(basePackages = "com.coviam.dao")
@SpringBootApplication
@ComponentScan(value = "com.coviam")
@ContextConfiguration(classes = {JpaConfig.class, MongoConfig.class},
        loader = AnnotationConfigContextLoader.class)
public class Application {
    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }
}

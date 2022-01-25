package in.as.sixtynine.rakku;

import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@EnableScheduling
@SpringBootApplication
@RequiredArgsConstructor
@EnableCosmosRepositories
public class RokkoApplication {

    private static final Logger log = LogManager.getLogger(RokkoApplication.class);
    private final Environment env;

    @PostConstruct
    public void initApplication() throws IOException {
        if (env.getActiveProfiles().length == 0) {
            log.warn("No Spring profile configured, running with default configuration");
        } else {
            log.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
            Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
            if (activeProfiles.contains("dev") && activeProfiles.contains("prod")) {
                log.error("You have misconfigured your application! It should not run with both the 'dev' and 'prod' profiles at the same time.");
            }
            if (activeProfiles.contains("prod") && activeProfiles.contains("test")) {
                log.error("You have misconfigured your application! It should not run with both the 'prod' and 'fast' profiles at the same time.");
            }
        }
    }

    public static void main(String[] args) {
        log.info("Starting app now....");
        SpringApplication.run(RokkoApplication.class, args);
    }

}

package in.as.sixtynine.rakku;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class RokkoApplication {

	public static void main(String[] args) {
		log.info("Starting app now....");
		SpringApplication.run(RokkoApplication.class, args);
	}

}

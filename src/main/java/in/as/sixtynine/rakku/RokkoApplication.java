package in.as.sixtynine.rakku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RokkoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RokkoApplication.class, args);
	}

}

package neo.nae.dododok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DododokApplication {

	public static void main(String[] args) {
		SpringApplication.run(DododokApplication.class, args);
	}

}

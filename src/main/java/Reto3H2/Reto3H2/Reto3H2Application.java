package Reto3H2.Reto3H2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
//@EntityScan(basePackages = ("Reto3H2.Modelos"))
public class Reto3H2Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3H2Application.class, args);
	}

}

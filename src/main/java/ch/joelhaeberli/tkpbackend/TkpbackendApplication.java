package ch.joelhaeberli.tkpbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {TkpCustomerController.class, TkpAdminController.class})
public class TkpbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TkpbackendApplication.class, args);
	}
}

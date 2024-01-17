package allali.com.apogee;

import allali.com.apogee.repository.EtudiantRepository;
import allali.com.apogee.repository.ModuleRepository;
import allali.com.apogee.services.Initiation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApogeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApogeeApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(Initiation initiation){
		return args -> {
			initiation.Initiation();
		};

	}
}

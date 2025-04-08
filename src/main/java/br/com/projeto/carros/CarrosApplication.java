package br.com.projeto.carros;

import br.com.projeto.carros.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CarrosApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}

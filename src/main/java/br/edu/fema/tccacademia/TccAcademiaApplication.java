package br.edu.fema.tccacademia;

import br.edu.fema.tccacademia.models.pessoa.Pessoa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TccAcademiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TccAcademiaApplication.class, args);
	}


	public void run(String... args) throws Exception {
		Pessoa pessoa = new Pessoa();

	}
}

package br.com.bibliotecajogos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("br.com.bibliotecajogos.entity")
@EnableJpaRepositories("br.com.bibliotecajogos.repository")
public class BibliotecajogosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecajogosApplication.class, args);
	}

}

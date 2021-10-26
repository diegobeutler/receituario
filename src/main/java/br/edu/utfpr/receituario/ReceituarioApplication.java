package br.edu.utfpr.receituario;

import br.edu.utfpr.receituario.service.useCase.impl.CriarReceituarioServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReceituarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceituarioApplication.class, args);
		//todo tentei executar aqui mas deu erro
	}

}

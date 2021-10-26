package br.edu.utfpr.receituario;

import br.edu.utfpr.receituario.model.Doenca;
import br.edu.utfpr.receituario.model.Remedio;
import br.edu.utfpr.receituario.model.Tratamento;
import br.edu.utfpr.receituario.service.useCase.impl.CriarReceituarioServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class ReceituarioApplication {

	private final CriarReceituarioServiceImpl criarReceituarioServiceImpl;

	public ReceituarioApplication(CriarReceituarioServiceImpl criarReceituarioServiceImpl) {
		this.criarReceituarioServiceImpl = criarReceituarioServiceImpl;
	}

	public static void main(String[] args) {
		SpringApplication.run(ReceituarioApplication.class, args);
	}

	@PostConstruct
	public void execute() {
		List<Doenca> doencas = List.of(Doenca.builder()
						.id(1L)
						.descricao("Gripe")
						.remedio(List.of(Remedio.builder().id(1L).descricao("Cimegripe").build()))
						.tratamento(List.of(Tratamento.builder().id(1L).descricao("repouso").build())).build(),
				Doenca.builder()
						.id(2L)
						.descricao("Dor de cabeça")
						.remedio(List.of(Remedio.builder().id(1L).descricao("Parecetamol").build()))
						.tratamento(List.of(Tratamento.builder().id(1L).descricao("repouso").build())).build());
		criarReceituarioServiceImpl.criarReceituario(doencas, 5, "João", "Receituario 1");
	}

}

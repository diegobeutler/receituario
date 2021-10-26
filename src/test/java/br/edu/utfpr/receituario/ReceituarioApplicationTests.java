package br.edu.utfpr.receituario;

import br.edu.utfpr.receituario.model.Doenca;
import br.edu.utfpr.receituario.model.Receituario;
import br.edu.utfpr.receituario.model.Remedio;
import br.edu.utfpr.receituario.model.Tratamento;
import br.edu.utfpr.receituario.service.Impl.ReceituarioServiceImpl;
import br.edu.utfpr.receituario.service.ReceituarioService;
import br.edu.utfpr.receituario.service.useCase.CriarReceituarioService;
import br.edu.utfpr.receituario.service.useCase.impl.CriarReceituarioServiceImpl;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;



import java.time.LocalDate;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class ReceituarioApplicationTests {

	@Mock
	private ReceituarioService receituarioService;

	@InjectMocks
	private ReceituarioServiceImpl receituarioServiceImpl = new ReceituarioServiceImpl();

	private CriarReceituarioServiceImpl criarReceituarioServiceImpl = new CriarReceituarioServiceImpl();

	@Test
	public void criarReceituarioTest() {

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
		Receituario receituario = criarReceituarioServiceImpl.criarReceituario(doencas, 5, "João");
		Assert.assertEquals(LocalDate.now().plusDays(5), receituario.getDataFinal());
	}

}

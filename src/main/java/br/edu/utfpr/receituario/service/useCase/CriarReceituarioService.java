package br.edu.utfpr.receituario.service.useCase;

import br.edu.utfpr.receituario.model.Doenca;
import br.edu.utfpr.receituario.model.Receituario;

import java.util.List;

public interface CriarReceituarioService {
    Receituario criarReceituario(List<Doenca> doencas, Integer numeroDias, String nomePaciente);
}

package br.edu.utfpr.receituario.service.useCase.impl;

import br.edu.utfpr.receituario.model.Doenca;
import br.edu.utfpr.receituario.model.Receituario;
import br.edu.utfpr.receituario.service.Impl.ReceituarioServiceImpl;
import br.edu.utfpr.receituario.service.useCase.CriarReceituarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CriarReceituarioServiceImpl implements CriarReceituarioService {

    @Autowired
    private ReceituarioServiceImpl receituarioServiceImpl;

    @Override
    public Receituario criarReceituario(List<Doenca> doencas, Integer numeroDias, String nomePaciente, String descricao) {
        Receituario entity = Receituario.builder()
                .doenca(doencas)
                .numeroDias(numeroDias)
                .dataEmissao(LocalDate.now())
                .descricao(descricao)
                .nomePaciente(nomePaciente)
                .build();

        return receituarioServiceImpl.save(entity);
    }
}

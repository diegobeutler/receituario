package br.edu.utfpr.receituario.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class Receituario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomePaciente;

    @Column(nullable = false)
    private String descricao;

    @ManyToMany
    @JoinTable(name = "receituario_doenca", joinColumns = @JoinColumn(name = "receituario_id"), inverseJoinColumns = @JoinColumn(name = "doenca_id"))
    private List<Doenca> doenca;

    private LocalDate dataEmissao;

    private Integer numeroDias;

    public LocalDate getDataFinal() {
        return dataEmissao. plusDays(numeroDias);
    }
}

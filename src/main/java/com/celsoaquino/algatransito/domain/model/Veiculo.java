package com.celsoaquino.algatransito.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Veiculo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;

    private String modelo;

    private String placa;

    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;

    private OffsetDateTime dataCadastro;

    private OffsetDateTime dataAprensao;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

    @OneToMany(mappedBy = "veiculo")
    private List<Autuacao> autuacaos = new ArrayList<>();

    public Autuacao adicionarAutuacao(Autuacao autuacao) {
        autuacao.setDataOcorrencia(OffsetDateTime.now());
        autuacao.setVeiculo(this);
        getAutuacaos().add(autuacao);
        return autuacao;
    }

}
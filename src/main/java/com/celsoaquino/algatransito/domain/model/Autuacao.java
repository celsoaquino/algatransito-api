package com.celsoaquino.algatransito.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "autuacao")
public class Autuacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    private String descricao;

    @Positive
    private BigDecimal valorMulta;

    private OffsetDateTime dataOcorrencia;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

}
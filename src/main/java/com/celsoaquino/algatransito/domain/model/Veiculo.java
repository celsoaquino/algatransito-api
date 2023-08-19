package com.celsoaquino.algatransito.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Veiculo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @Pattern(regexp = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}")
    @NotBlank
    private String placa;

    @JsonProperty(access = READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;

    @JsonProperty(access = READ_ONLY)
    private LocalDateTime dataCadastro;

    @JsonProperty(access = READ_ONLY)
    private LocalDateTime dataAprensao;

    @Valid
    @NotNull
    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;


}
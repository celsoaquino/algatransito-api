package com.celsoaquino.algatransito.domain.service;

import com.celsoaquino.algatransito.domain.model.StatusVeiculo;
import com.celsoaquino.algatransito.domain.model.Veiculo;
import com.celsoaquino.algatransito.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistroVeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Transactional
    public Veiculo cadastrar(Veiculo veiculo) {
        veiculo.setStatus(StatusVeiculo.REGULAR);
        veiculo.setDataCadastro(LocalDateTime.now());

        return veiculoRepository.save(veiculo);
    }
}

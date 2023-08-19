package com.celsoaquino.algatransito.domain.service;

import com.celsoaquino.algatransito.domain.model.Autuacao;
import com.celsoaquino.algatransito.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RegistroAutuacaoService {

    private final VeiculoRepository veiculoRepository;
    private final RegistroVeiculoService registroVeiculoService;

    @Transactional
    public Autuacao registrar(Long veiculoId, Autuacao novaAutuacao) {
        var veiculo = registroVeiculoService.buscar(veiculoId);

        return veiculo.adicionarAutuacao(novaAutuacao);
    }
}

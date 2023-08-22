package com.celsoaquino.algatransito.api.controller;

import com.celsoaquino.algatransito.api.assembler.AutuacaoAssembler;
import com.celsoaquino.algatransito.api.model.AutuacaoModel;
import com.celsoaquino.algatransito.api.model.input.AutuacaoInput;
import com.celsoaquino.algatransito.domain.model.Autuacao;
import com.celsoaquino.algatransito.domain.service.RegistroAutuacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos/{veiculoId}/autuacoes")
public class AutuacaoController {

    private final RegistroAutuacaoService registroAutuacaoService;
    private final AutuacaoAssembler autuacaoAssembler;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoModel registrar(@Valid @RequestBody AutuacaoInput autuacaoInput,
                                   @PathVariable Long veiculoId) {

        Autuacao novaAutuacao = autuacaoAssembler.toEntity(autuacaoInput);

        Autuacao autuacaoRegistrada = registroAutuacaoService.registrar(veiculoId, novaAutuacao);

        return autuacaoAssembler.toModel(autuacaoRegistrada);
    }
}

package com.celsoaquino.algatransito.api.controller;

import com.celsoaquino.algatransito.domain.model.Proprietario;
import com.celsoaquino.algatransito.domain.repository.ProprietarioRespository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProprietarioController {

    private final ProprietarioRespository repository;

    @GetMapping("/proprietarios")
    public List<Proprietario> list() {
        return repository.findAll();
    }
}

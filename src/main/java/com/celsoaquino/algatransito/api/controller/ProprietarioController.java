package com.celsoaquino.algatransito.api.controller;

import com.celsoaquino.algatransito.domain.model.Proprietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProprietarioController {

    @GetMapping("/proprietarios")
    public List<Proprietario> list() {
        return List.of(
                new Proprietario(1L, "Celso", "email", "156465"),
                new Proprietario(2L, "Joao", "mail", "5465465"));
    }
}

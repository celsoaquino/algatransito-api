package com.celsoaquino.algatransito.api.controller;

import com.celsoaquino.algatransito.domain.model.Proprietario;
import com.celsoaquino.algatransito.domain.repository.ProprietarioRespository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/proprietarios")
public class ProprietarioController {

    private final ProprietarioRespository repository;

    @GetMapping
    public List<Proprietario> list() {
        return repository.findAll();
    }

    @GetMapping("/{proprietarioId}")
    public ResponseEntity<Proprietario> findById(@PathVariable Long proprietarioId) {
        return repository.findById(proprietarioId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}

package com.celsoaquino.algatransito.api.controller;

import com.celsoaquino.algatransito.domain.model.Proprietario;
import com.celsoaquino.algatransito.domain.repository.ProprietarioRespository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proprietario create(@RequestBody Proprietario proprietario) {
        return repository.save(proprietario);
    }

    @PutMapping("/{proprietarioId}")
    public ResponseEntity<Proprietario> update(@PathVariable Long proprietarioId,
                                               @RequestBody Proprietario proprietario) {
        if (!repository.existsById(proprietarioId)) {
            return ResponseEntity.notFound().build();
        }

        proprietario.setId(proprietarioId);
        var proprietarioAtualizado = repository.save(proprietario);

        return ResponseEntity.ok(proprietarioAtualizado);
    }

    @DeleteMapping("/{proprietarioId}")
    public ResponseEntity<Void> delete(@PathVariable Long proprietarioId) {
        if (!repository.existsById(proprietarioId)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(proprietarioId);
        return ResponseEntity.noContent().build();
    }
}

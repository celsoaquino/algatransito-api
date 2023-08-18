package com.celsoaquino.algatransito.api.controller;

import com.celsoaquino.algatransito.domain.model.Proprietario;
import com.celsoaquino.algatransito.domain.repository.ProprietarioRespository;
import com.celsoaquino.algatransito.domain.service.RegistroProprietarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/proprietarios")
public class ProprietarioController {

    private final ProprietarioRespository proprietarioRespository;
    private final RegistroProprietarioService proprietarioService;

    @GetMapping
    public List<Proprietario> list() {
        return proprietarioRespository.findAll();
    }

    @GetMapping("/{proprietarioId}")
    public ResponseEntity<Proprietario> findById(@PathVariable Long proprietarioId) {
        return proprietarioRespository.findById(proprietarioId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proprietario create(@Valid @RequestBody Proprietario proprietario) {
        return proprietarioService.save(proprietario);
    }

    @PutMapping("/{proprietarioId}")
    public ResponseEntity<Proprietario> update(@PathVariable Long proprietarioId,
                                               @RequestBody Proprietario proprietario) {
        if (!proprietarioRespository.existsById(proprietarioId)) {
            return ResponseEntity.notFound().build();
        }

        proprietario.setId(proprietarioId);
        var proprietarioAtualizado = proprietarioService.save(proprietario);

        return ResponseEntity.ok(proprietarioAtualizado);
    }

    @DeleteMapping("/{proprietarioId}")
    public ResponseEntity<Void> delete(@PathVariable Long proprietarioId) {
        if (!proprietarioRespository.existsById(proprietarioId)) {
            return ResponseEntity.notFound().build();
        }

        proprietarioService.deleteById(proprietarioId);
        return ResponseEntity.noContent().build();
    }
}

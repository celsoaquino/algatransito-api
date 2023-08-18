package com.celsoaquino.algatransito.domain.service;

import com.celsoaquino.algatransito.domain.model.Proprietario;
import com.celsoaquino.algatransito.domain.repository.ProprietarioRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroProprietarioService {

    private final ProprietarioRespository proprietarioRespository;

    @Transactional
    public Proprietario save(Proprietario proprietario) {
        return proprietarioRespository.save(proprietario);
    }

    @Transactional
    public void deleteById(Long proprietarioId) {
        proprietarioRespository.deleteById(proprietarioId);
    }
}

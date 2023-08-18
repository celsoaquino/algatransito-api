package com.celsoaquino.algatransito.domain.service;

import com.celsoaquino.algatransito.domain.exception.NegocioException;
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
        boolean emailEmUso = proprietarioRespository.findByEmail(proprietario.getEmail())
                .filter(p -> !p.equals(proprietario))
                .isPresent();

        if (emailEmUso) {
            throw new NegocioException("Já existe um proprietario cadastrado com este e-mail");
        }


        return proprietarioRespository.save(proprietario);
    }

    @Transactional
    public void deleteById(Long proprietarioId) {
        proprietarioRespository.deleteById(proprietarioId);
    }
}

package com.celsoaquino.algatransito.domain.repository;

import com.celsoaquino.algatransito.domain.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProprietarioRespository extends JpaRepository<Proprietario, Long> {

    List<Proprietario> findByNameContaining(String name);
    Optional<Proprietario> findByEmail(String email);
}

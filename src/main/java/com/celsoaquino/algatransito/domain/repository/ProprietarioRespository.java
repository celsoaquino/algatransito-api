package com.celsoaquino.algatransito.domain.repository;

import com.celsoaquino.algatransito.domain.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietarioRespository extends JpaRepository<Proprietario, Long> {
}

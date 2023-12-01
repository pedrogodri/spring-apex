package br.com.medico.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.medico.api.model.Peca;

public interface PecasRepository extends JpaRepository<Peca, Long> {
    List<Peca> findAll();
    Peca findById(long peca_id);
}

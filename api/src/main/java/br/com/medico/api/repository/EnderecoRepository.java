package br.com.medico.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.medico.api.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}

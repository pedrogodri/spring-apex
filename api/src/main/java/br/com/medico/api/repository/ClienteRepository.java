package br.com.medico.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.medico.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}

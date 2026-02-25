package org.luishernandez.webApp.repository;

import org.luishernandez.webApp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByIdentificacion(String identificacion);
    
    List<Cliente> findByActivoTrue();
    
    Optional<Cliente> findByIdAndActivoTrue(Long id);
}
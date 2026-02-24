package org.luishernandez.webApp.repository;

import org.luishernandez.webApp.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}

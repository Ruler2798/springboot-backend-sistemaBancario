package org.luishernandez.webApp.repository;

import org.luishernandez.webApp.model.EstadoSolicitud;
import org.luishernandez.webApp.model.SolicitudPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudPrestamoRepository extends JpaRepository<SolicitudPrestamo, Long> {

    List<SolicitudPrestamo> findByEstado(EstadoSolicitud estado);
}

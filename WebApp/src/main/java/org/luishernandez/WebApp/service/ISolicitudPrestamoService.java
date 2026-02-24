package org.luishernandez.webApp.service;

import org.luishernandez.webApp.model.Prestamo;
import org.luishernandez.webApp.model.SolicitudPrestamo;

import java.util.List;
import java.util.Optional;

public interface ISolicitudPrestamoService {

    List<SolicitudPrestamo> listar();

    Optional<SolicitudPrestamo> buscarPorId(Long id);

    SolicitudPrestamo guardar(SolicitudPrestamo solicitud);

    Prestamo aprobar(Long solicitudId);

    void rechazar(Long solicitudId);
}


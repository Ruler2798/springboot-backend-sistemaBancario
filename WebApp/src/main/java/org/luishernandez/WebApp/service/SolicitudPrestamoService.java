package org.luishernandez.webApp.service;

import org.luishernandez.webApp.model.EstadoSolicitud;
import org.luishernandez.webApp.model.Prestamo;
import org.luishernandez.webApp.model.SolicitudPrestamo;
import org.luishernandez.webApp.repository.PrestamoRepository;
import org.luishernandez.webApp.repository.SolicitudPrestamoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudPrestamoService {

    private final SolicitudPrestamoRepository solicitudRepo;
    private final PrestamoRepository prestamoRepo;

    public SolicitudPrestamoService(
            SolicitudPrestamoRepository solicitudRepo,
            PrestamoRepository prestamoRepo
    ) {
        this.solicitudRepo = solicitudRepo;
        this.prestamoRepo = prestamoRepo;
    }

    public List<SolicitudPrestamo> listar() {
        return solicitudRepo.findAll();
    }

    public Optional<SolicitudPrestamo> buscarPorId(Long id) {
        return solicitudRepo.findById(id);
    }

    public SolicitudPrestamo guardar(SolicitudPrestamo solicitud) {
        if (solicitud.getEstado() == null) {
            solicitud.setEstado(EstadoSolicitud.PENDIENTE);
        }
        return solicitudRepo.save(solicitud);
    }

@Transactional
    public SolicitudPrestamo aprobar(Long solicitudId) {

        SolicitudPrestamo solicitud = solicitudRepo.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        
        if (solicitud.getEstado() != EstadoSolicitud.PENDIENTE) {
            throw new RuntimeException("La solicitud ya fue procesada");
        }

        solicitud.setEstado(EstadoSolicitud.APROBADA);

        Prestamo prestamo = new Prestamo(
                solicitud.getCliente(),
                solicitud.getMontoSolicitado(),
                solicitud.getPlazoMeses(),
                solicitud.getTasaInteres(),
                solicitud
        );

        prestamoRepo.save(prestamo);

        return solicitudRepo.save(solicitud);
    }

    public SolicitudPrestamo rechazar(Long solicitudId) {
        SolicitudPrestamo solicitud = solicitudRepo.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        solicitud.setEstado(EstadoSolicitud.RECHAZADA);
        return solicitudRepo.save(solicitud);
    }
}


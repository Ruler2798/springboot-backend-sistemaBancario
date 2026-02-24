package org.luishernandez.webApp.controller;

import org.luishernandez.webApp.model.SolicitudPrestamo;
import org.luishernandez.webApp.service.SolicitudPrestamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudPrestamoController {

    private final SolicitudPrestamoService service;

    public SolicitudPrestamoController(SolicitudPrestamoService service) {
        this.service = service;
    }

    @GetMapping
    public List<SolicitudPrestamo> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudPrestamo> obtener(@PathVariable Long id) {
        Optional<SolicitudPrestamo> solicitud = service.buscarPorId(id);
        return solicitud
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SolicitudPrestamo crear(@RequestBody SolicitudPrestamo solicitud) {
        return service.guardar(solicitud);
    }

    @PutMapping("/{id}/aprobar")
    public ResponseEntity<SolicitudPrestamo> aprobar(@PathVariable Long id) {
        return ResponseEntity.ok(service.aprobar(id));
    }

    @PutMapping("/{id}/rechazar")
    public ResponseEntity<SolicitudPrestamo> rechazar(@PathVariable Long id) {
        return ResponseEntity.ok(service.rechazar(id));
    }
}


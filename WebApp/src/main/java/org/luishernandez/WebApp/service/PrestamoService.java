package org.luishernandez.webApp.service;

import org.luishernandez.webApp.model.Prestamo;
import org.luishernandez.webApp.repository.PrestamoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public Prestamo buscarPorId(Long id) {
        return prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
    }

    public List<Prestamo> listar() {
        return prestamoRepository.findAll();
    }
}


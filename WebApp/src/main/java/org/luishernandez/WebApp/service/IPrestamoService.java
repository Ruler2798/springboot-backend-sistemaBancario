package org.luishernandez.webApp.service;

import org.luishernandez.webApp.model.Prestamo;

import java.util.List;

public interface IPrestamoService {

    Prestamo buscarPorId(Long id);

    List<Prestamo> listar();
}


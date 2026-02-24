package org.luishernandez.webApp.service;

import org.luishernandez.webApp.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    Cliente guardar(Cliente cliente);

    List<Cliente> listar();

    Optional<Cliente> buscarPorId(Long id);
}


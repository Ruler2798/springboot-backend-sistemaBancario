package org.luishernandez.webApp.service;

import org.luishernandez.webApp.model.Cliente;
import org.luishernandez.webApp.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente actualizar(Long id, Cliente datosActualizados) {
        Cliente existente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        existente.setNombre(datosActualizados.getNombre());
        existente.setApellido(datosActualizados.getApellido());
        existente.setIdentificacion(datosActualizados.getIdentificacion());

        return clienteRepository.save(existente);
    }

    public void eliminar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente no encontrado");
        }
        clienteRepository.deleteById(id);
    }
}


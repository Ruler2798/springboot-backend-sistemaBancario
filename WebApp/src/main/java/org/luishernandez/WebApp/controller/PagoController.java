package org.luishernandez.webApp.controller;

import org.luishernandez.webApp.model.Pago;
import org.luishernandez.webApp.service.PagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pago> listar() {
        return service.listar();
    }

    @PostMapping
    public Pago registrar(@RequestBody Pago pago) {
        return service.guardar(pago);
    }
}


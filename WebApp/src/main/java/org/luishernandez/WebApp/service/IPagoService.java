package org.luishernandez.webApp.service;

import org.luishernandez.webApp.model.Pago;

import java.util.List;

public interface IPagoService {

    List<Pago> listar();

    Pago guardar(Pago pago);
}


package org.luishernandez.webApp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto_pagado", nullable = false, precision = 15, scale = 2)
    private BigDecimal montoPagado;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "prestamo_id", nullable = false)
    private Prestamo prestamo;

    protected Pago() {
        // requerido por JPA
    }

    @PrePersist
    protected void onCreate() {
        this.fechaPago = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(BigDecimal montoPagado) {
        this.montoPagado = montoPagado;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
}

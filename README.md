# springboot-backend-sistemaBancario
Backend de un Sistema Banrio 
# 🏦 Sistema Bancario – Backend (Spring Boot)

![Java](https://img.shields.io/badge/Java-21-orange?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen?logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-8-blue?logo=mysql)
![Maven](https://img.shields.io/badge/Maven-3.9.12-red?logo=apachemaven)
![Status](https://img.shields.io/badge/Status-En%20Desarrollo-yellow)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

Backend del **Sistema de Préstamos Bancarios**, desarrollado con **Spring Boot**, que permite la gestión de clientes, solicitudes de préstamo, préstamos aprobados y pagos.  
Diseñado para ser consumido por un frontend en **React** mediante una API REST.

---

## 🚀 Tecnologías utilizadas

- **Java 21**
- **Spring Boot 3.2.5**
- **Spring Data JPA (Hibernate)**
- **MySQL 8**
- **Maven**
- **Lombok**
- **Postman**

---

## 🧱 Arquitectura

Arquitectura en capas:

Controller → Service → Repository → Database


### 📂 Estructura del proyecto
org.luishernandez.WebApp
│
├── controller
├── service
│ ├── interfaces
│ └── impl
├── repository
├── model
├── config
└── WebAppApplication.java


---

## 📦 Entidades principales

### 👤 Cliente
- id
- nombre
- apellido
- identificacion (única)
- fechaRegistro

### 📄 SolicitudPrestamo
- id
- montoSolicitado
- plazoMeses
- tasaInteres
- estado (PENDIENTE | APROBADA | RECHAZADA)
- fechaSolicitud
- cliente

### 💳 Prestamo
- id
- monto
- plazoMeses
- tasaInteres
- fechaInicio
- cliente
- solicitud

### 💰 Pago
- id
- montoPagado
- fechaPago
- prestamo

---

## 🔄 Flujo de negocio

1. Registrar cliente
2. Crear solicitud de préstamo
3. Aprobar solicitud
4. Crear préstamo automáticamente
5. Registrar pagos del préstamo

---

## 🌐 Endpoints REST

### 👤 Clientes

| Método | Endpoint | Descripción |
|------|---------|------------|
| POST | `/api/clientes` | Crear cliente |
| GET | `/api/clientes` | Listar clientes |

### Solicitudes de Préstamo

| Método | Endpoint                        | Descripción        |
| ------ | ------------------------------- | ------------------ |
| POST   | `/api/solicitudes`              | Crear solicitud    |
| GET    | `/api/solicitudes`              | Listar solicitudes |
| PUT    | `/api/solicitudes/{id}/aprobar` | Aprobar solicitud  |

**Ejemplo JSON**
```json
{
  "nombre": "Luis",
  "apellido": "Hernandez",
  "identificacion": "ABC123456"
}
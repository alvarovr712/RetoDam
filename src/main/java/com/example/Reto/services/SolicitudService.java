package com.example.Reto.services;


import com.example.Reto.model.Solicitud;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SolicitudService {

    Solicitud crearSolicitud (Solicitud solicitud);
    List<Solicitud> buscarSolicitudesPorUsuario(String username);
    ResponseEntity<?> cancelarSolicitud(int id_solicitud);
    String rechazarSolicitud(int id_solicitud);
}

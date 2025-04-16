package com.example.Reto.services;


import com.example.Reto.model.Solicitud;

import java.util.List;

public interface SolicitudService {

    Solicitud crearSolicitud (Solicitud solicitud);
    List<Solicitud> buscarSolicitudesPorUsuario(String username);
    String borrarSolicitud(int id_solicitud);
}

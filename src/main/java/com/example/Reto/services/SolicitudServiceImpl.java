package com.example.Reto.services;

import com.example.Reto.model.Solicitud;
import com.example.Reto.model.Vacante;
import com.example.Reto.repository.SolicitudRepository;
import com.example.Reto.repository.VacanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudServiceImpl implements SolicitudService{

    @Autowired
    private SolicitudRepository solicitudRepository;
    @Autowired
    private VacanteRepository vacanteRepository;
        // ------------   USUARIO -----------
    @Override
    public Solicitud crearSolicitud(Solicitud solicitud) {
        Vacante vacante = vacanteRepository.findById(solicitud.getVacante().getId_vacante()).orElse(null);

        if(vacante == null) {
            return null;
        }

        Solicitud solicitud1 = solicitudRepository.buscarUsernameIdVacante(
                solicitud.getUsuario().getUsername(),
                solicitud.getVacante().getId_vacante()
        );

        if(solicitud1  != null){
            return null;
        }

        solicitud.setVacante(vacante);
        solicitud.setFecha(LocalDate.now());
        solicitud.setEstado(0);

        return solicitudRepository.save(solicitud);

//        return solicitud;
    }

    @Override
    public List<Solicitud> buscarSolicitudesPorUsuario(String username) {
        return solicitudRepository.buscarSolicitudesPorUsername(username);
    }

    @Override
    public String cancelarSolicitud(int id_solicitud) {
        Solicitud solicitud = solicitudRepository.findById(id_solicitud).orElse(null);

        if(solicitud == null){
            return "La solicitud no fue encontrada";
        }

        if(solicitud.getEstado() == 1){
            return "No se puede eliminar la solicitud  ya que se ha aceptado";
        }
        solicitud.setEstado(3);
        solicitudRepository.save(solicitud);



        return "La solicitud ha sido cancelada correctamente";

    }

    // ------ EMPRESA ------------

    @Override
    public String rechazarSolicitud(int id_solicitud) {
        Solicitud solicitud = solicitudRepository.findById(id_solicitud).orElse(null);

        if(solicitud == null){
            return "La solicitud no fue encontrada";
        }

        if(solicitud.getEstado() == 1){
            return "No se puede rechazar la solicitud  ya que se ha aceptado";
        }
        solicitud.setEstado(2);
        solicitudRepository.save(solicitud);



        return "La solicitud ha sido rechazada correctamente";
    }
}

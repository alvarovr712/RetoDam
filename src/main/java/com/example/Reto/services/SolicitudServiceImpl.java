package com.example.Reto.services;

import com.example.Reto.model.Solicitud;
import com.example.Reto.model.Vacante;
import com.example.Reto.repository.SolicitudRepository;
import com.example.Reto.repository.VacanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
public class SolicitudServiceImpl implements SolicitudService{

    @Autowired
    private SolicitudRepository solicitudRepository;
    @Autowired
    private VacanteRepository vacanteRepository;

    @Override
    public Solicitud crearSolicitud(Solicitud solicitud) {
        Vacante vacante = vacanteRepository.findById(solicitud.getVacante().getId_vacante()).orElse(null);

        if(vacante != null) {
            return null;
        }

        solicitud.setVacante(vacante);
        solicitud.setFecha(LocalDate.now());
        solicitud.setEstado(0);

        return solicitudRepository.save(solicitud);

//        return solicitud;
    }
}

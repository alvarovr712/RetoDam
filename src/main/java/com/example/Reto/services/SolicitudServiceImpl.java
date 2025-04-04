package com.example.Reto.services;

import com.example.Reto.model.Solicitud;
import com.example.Reto.model.Vacante;
import com.example.Reto.repository.SolicitudRepository;
import com.example.Reto.repository.VacanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class SolicitudServiceImpl implements SolicitudService{

    @Autowired
    private SolicitudRepository solicitudRepository;
    @Autowired
    private VacanteRepository vacanteRepository;

    @Override
    public Solicitud crearSolicitud(Solicitud solicitud, String nombre) {

        Vacante vacante = vacanteRepository.findIdByNombre(nombre);

        if(vacante != null){
            solicitud.setVacante(vacante);
            solicitud.setFecha(LocalDate.now());
            solicitud.setEstado(0);
            return solicitudRepository.save(solicitud);
        }else {
            return null;
        }



    }
}

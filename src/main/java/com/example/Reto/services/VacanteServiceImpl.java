package com.example.Reto.services;

import com.example.Reto.model.Solicitud;
import com.example.Reto.model.Vacante;
import com.example.Reto.repository.SolicitudRepository;
import com.example.Reto.repository.VacanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacanteServiceImpl implements VacanteService{

    @Autowired
    private VacanteRepository vacanteRepository;
    @Autowired
    private SolicitudRepository solicitudRepository;

    // Antes de guardar la vacante e insertarla en la base de datos le cambiamos el estatus a la vacante a CREADA para que siempre que se cree tenga ese estatus
    @Override
    public Vacante publicarVacante(Vacante vacante) {
        vacante.setEstatus(Vacante.Estatus.CREADA);
        return vacanteRepository.save(vacante);
    }

    @Override
    public void borrarVacante(String nombre) {
        Vacante vacante = vacanteRepository.findByNombre(nombre);
        if(vacante != null){
            vacante.setEstatus(Vacante.Estatus.CANCELADA);
            vacanteRepository.save(vacante);
            System.out.println("La vacante ha sido borrada con éxito");
        }else {
            System.out.println("No se encontrón ninguna vacante con el nombre: " + nombre);
        }

    }

    @Override
    public void asignarVacante(String nombreVacante, int id_solicitud) {

        Vacante vacante = vacanteRepository.findByNombre(nombreVacante);
        Solicitud solicitud = solicitudRepository.findById(id_solicitud).orElse(null);
        if(vacante != null &&  solicitud != null){
            vacante.setEstatus(Vacante.Estatus.ASIGNADA);
            vacanteRepository.save(vacante);
            solicitud.setEstado(1);
            solicitudRepository.save(solicitud);

        }else {
            System.out.println("El nombre de la vacante o el id de la solicitud es incorrecto");
        }



    }


}

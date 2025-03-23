package com.example.Reto.services;

import com.example.Reto.model.Solicitud;
import com.example.Reto.model.Vacante;

import java.util.List;

public interface VacanteService {
    // ------------------ EMPRESA -------------
    public Vacante publicarVacante(Vacante vacante);
    public void borrarVacante(String nombre);
    public void asignarVacante(String nombreVacante,int id_solicitud);
    public List<Solicitud> obtenerSolicitudesDeVacante(int id_vacante);

}

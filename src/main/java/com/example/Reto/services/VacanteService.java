package com.example.Reto.services;

import com.example.Reto.model.Vacante;

public interface VacanteService {

    public Vacante publicarVacante(Vacante vacante);
    public void borrarVacante(String nombre);
    public void asignarVacante(String nombreVacante,int id_solicitud);

}

package com.example.Reto.services;

import com.example.Reto.model.Solicitud;
import com.example.Reto.model.Vacante;

import java.util.List;
import java.util.Optional;

public interface VacanteService {
    // ------------------ EMPRESA -------------
    public Vacante publicarVacante(Vacante vacante);
    public void borrarVacante(int id_vacante);
    public void asignarVacante(int id_vacante,int id_solicitud);
    public List<Solicitud> obtenerSolicitudesDeVacante(int id_vacante);
    public Optional<Vacante> buscarVacantePorId(int id_vacante);
    public List<Vacante> buscarTodas();
    public Vacante modificarVacante(int id_vacante, Vacante nuevavacante);
    // --------------- USUARIO ---------------------
    public List<Vacante> buscarPorEmpresa(int id_empresa);
    public List<Vacante> buscarPorCategoria(int id_categoria);

}

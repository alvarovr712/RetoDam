package com.example.Reto.services;

import com.example.Reto.model.Solicitud;
import com.example.Reto.model.Vacante;
import com.example.Reto.model.VacanteDTO;

import java.util.List;
import java.util.Optional;

public interface VacanteService {
    // ------------------ EMPRESA -------------
    public Vacante publicarVacante(Vacante vacante, int id_empresa);
    public void borrarVacante(int id_vacante);
    public void asignarVacante(int id_vacante,int id_solicitud);
    public List<Solicitud> obtenerSolicitudesDeVacante(int id_vacante);
    public Optional<Vacante> buscarVacantePorId(int id_vacante);
    public List<Vacante> buscarTodas(int id_empresa);
    public Vacante modificarVacante(int id_vacante, Vacante nuevavacante);
    // --------------- USUARIO ---------------------
    public List<VacanteDTO> buscarPorEmpresa(String nombre);
    public List<VacanteDTO> buscarPorCategoria(String nombre);
    public List<Vacante> verVacantesCreadas();


}

package com.example.Reto.repository;

import com.example.Reto.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface VacanteRepository extends JpaRepository<Vacante,Integer> {

    Vacante findByNombre(String nombre);

    @Query("SELECT v FROM vacante v WHERE v.empresa.id_empresa = :id_empresa AND v.estatus = 'CREADA'")
    List<Vacante> findByEmpresa(int id_empresa);
    @Query("SELECT v FROM vacante v WHERE v.estatus = 'CREADA' AND v.categoria.id_categoria = :id_categoria")
    List<Vacante> findByCategoria(Integer id_categoria);
    @Query("SELECT v FROM vacante v WHERE v.empresa.id = :id_empresa")
    List<Vacante> findByIdEmpresa(int id_empresa);
    //Esta query es necesaria para poder ingresar el id_vacante en la solicitud, usada en SolicitudService
    @Query("SELECT v FROM vacante v WHERE v.nombre = :nombre")
    Vacante findIdByNombre(String nombre);

    //Buscar vacantes por estatus
    @Query("SELECT v FROM vacante v WHERE v.estatus = 'CREADA'")
    List<Vacante> findVacantesByEstatus();

}

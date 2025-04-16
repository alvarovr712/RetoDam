package com.example.Reto.repository;

import com.example.Reto.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud,Integer> {
    @Query("SELECT s FROM Solicitud s WHERE s.usuario.username = :username AND s.vacante.id_vacante = :id_vacante")
    Solicitud buscarUsernameIdVacante(String username,int id_vacante);

    @Query("SELECT s FROM Solicitud s WHERE s.usuario.username = :username")
    List<Solicitud> buscarSolicitudesPorUsername(String username);
}

package com.example.Reto.repository;

import com.example.Reto.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud,Integer> {
}

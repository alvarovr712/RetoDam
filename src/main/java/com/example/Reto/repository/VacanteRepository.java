package com.example.Reto.repository;

import com.example.Reto.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacanteRepository extends JpaRepository<Vacante,Integer> {

    Vacante findByNombre(String nombre);
}

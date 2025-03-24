package com.example.Reto.repository;

import com.example.Reto.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
    Categoria findByNombre(String nombre);
}

package com.example.Reto.repository;

import com.example.Reto.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {

    @Query("SELECT e FROM Empresa e WHERE e.id_empresa = :id_empresa")
    Optional<Empresa> findByIdEmpresa( int id_empresa);
}

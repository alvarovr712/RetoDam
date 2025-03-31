package com.example.Reto.repository;

import com.example.Reto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findByUsername(String username);
    @Query("SELECT e.id_empresa FROM Empresa e WHERE e.responsable.username = :username")
    Integer findIdEmpresaByUsername(String username);

}

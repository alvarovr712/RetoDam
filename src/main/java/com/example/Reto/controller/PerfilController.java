package com.example.Reto.controller;

import com.example.Reto.model.Perfil;
import com.example.Reto.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

        //Crear un perfil (1 -> ADMIN, 2-> EMPRESA, 3 -> USUARIO)
    @PostMapping("nuevo")
    public ResponseEntity<Perfil> nuevoPerfil(@RequestBody Perfil perfil){
        return (new ResponseEntity<>(perfilService.crearPerfil(perfil), HttpStatus.OK));
    }
}

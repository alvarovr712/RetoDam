package com.example.Reto.controller;

import com.example.Reto.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;
}

package com.example.Reto.controller;

import com.example.Reto.model.Solicitud;
import com.example.Reto.model.Vacante;
import com.example.Reto.services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("solicitud")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @PostMapping("{nombre}")
    public ResponseEntity<Solicitud> crearSolicitud(@PathVariable String nombre, @RequestBody Solicitud solicitud){
        return (new ResponseEntity<>(solicitudService.crearSolicitud(solicitud,nombre), HttpStatus.OK));
    }
}

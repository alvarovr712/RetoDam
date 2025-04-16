package com.example.Reto.controller;

import com.example.Reto.model.Solicitud;
import com.example.Reto.model.Vacante;
import com.example.Reto.services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("solicitud")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @PostMapping("nueva")
    public ResponseEntity<Solicitud> crearSolicitud(@RequestBody Solicitud solicitud){
        Solicitud solicitud1 = solicitudService.crearSolicitud(solicitud);

        if(solicitud1 == null){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(solicitud1);
    }
    @GetMapping("/usuario/{username}")
    public ResponseEntity<List<Solicitud>> buscarSolicitudesDeUsuario(@PathVariable String username){
        return (new ResponseEntity<>(solicitudService.buscarSolicitudesPorUsuario(username),HttpStatus.OK));
    }

    @DeleteMapping("cancelar/{id_solicitud}")
    public ResponseEntity<String> cancelarSolicitud (@PathVariable int id_solicitud){
        return (new ResponseEntity<>(solicitudService.borrarSolicitud(id_solicitud),HttpStatus.OK));
    }
}

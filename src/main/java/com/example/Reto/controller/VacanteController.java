package com.example.Reto.controller;

import com.example.Reto.model.Solicitud;
import com.example.Reto.model.Vacante;
import com.example.Reto.services.VacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vacante")
public class VacanteController {

    @Autowired
    private VacanteService vacanteService;

    @PostMapping ("nuevavacante")
    public String nuevaVacante(@RequestBody Vacante vacante){

        vacanteService.publicarVacante(vacante);
        return "Vacante agregada correctamente";
    }

    @PutMapping("borrarvacante")
    public String borrarVacante(@RequestParam String nombre){
        vacanteService.borrarVacante(nombre);
        return "La vacante ha sido borrada con éxito";
    }

    @PutMapping("asignarvacante")
    public String asignarVacante(@RequestParam String nombreVacante,@RequestParam int id_solicitud){
        vacanteService.asignarVacante(nombreVacante,id_solicitud);
        return "La vacante se ha asignado correctamente";

    }
    //Obtener todas las solicitudes de una vacante
    @GetMapping("versolicitudes")
    public ResponseEntity<List<Solicitud>> obtenerSolicitudes(@RequestParam int id_vacante){
        return (new ResponseEntity<>(vacanteService.obtenerSolicitudesDeVacante(id_vacante),HttpStatus.OK));
    }

}

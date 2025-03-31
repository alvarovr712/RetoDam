package com.example.Reto.controller;

import com.example.Reto.model.Solicitud;
import com.example.Reto.model.Vacante;
import com.example.Reto.services.VacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("vacante")
public class VacanteController {

    @Autowired
    private VacanteService vacanteService;

    @PostMapping ("nuevavacante/{id_empresa}")
    public ResponseEntity<Vacante> nuevaVacante(@RequestBody Vacante vacante, @PathVariable int id_empresa){
        return (new ResponseEntity<>(vacanteService.publicarVacante(vacante,id_empresa),HttpStatus.OK));
    }

    @PutMapping("retirar/{id_vacante}")
    public String borrarVacante(@PathVariable int id_vacante){
        vacanteService.borrarVacante(id_vacante);
        return "La vacante ha sido borrada con éxito";
    }

    @PutMapping("asignar/{id_vacante}/{id_solicitud}")
    public String asignarVacante(@PathVariable int id_vacante,@PathVariable int id_solicitud){
        vacanteService.asignarVacante(id_vacante,id_solicitud);
        return "La vacante se ha asignado correctamente";

    }
    //Obtener todas las solicitudes de una vacante
    @GetMapping("solicitudes/{id_vacante}")
    public ResponseEntity<List<Solicitud>> obtenerSolicitudes(@PathVariable int id_vacante){
        return (new ResponseEntity<>(vacanteService.obtenerSolicitudesDeVacante(id_vacante),HttpStatus.OK));
    }

    //Buscar vacante por id
    @GetMapping("{id_vacante}")
    public ResponseEntity<Optional<Vacante>> vacantePorId(@PathVariable int id_vacante){
        return (new ResponseEntity<>(vacanteService.buscarVacantePorId(id_vacante),HttpStatus.OK));
    }
    //Buscar todas las vacantes
    @GetMapping("vacantes/{id_empresa}")
    public ResponseEntity<List<Vacante>> buscarTodas(@PathVariable int id_empresa){
        return (new ResponseEntity<>(vacanteService.buscarTodas(id_empresa),HttpStatus.OK));
    }

    //Modificar vacante(Se puede modificar solo el campo que se necesite y los demas quedaran igual que antes de la modificación)
    @PutMapping("modificar/{id_vacante}")
    public ResponseEntity<Vacante> modificarVacante(@PathVariable int id_vacante,@RequestBody Vacante vacante){
        return (new ResponseEntity<>(vacanteService.modificarVacante(id_vacante,vacante),HttpStatus.OK));
    }



    // ------------- USUARIO ------------------------
    //Filtro Empresa
    @GetMapping("empresa/{id_empresa}")
    public ResponseEntity<List<Vacante>> filtroEmpresa(@PathVariable int id_empresa){
        return (new ResponseEntity<>(vacanteService.buscarPorEmpresa(id_empresa),HttpStatus.OK));
    }
    //Filtro Categoria
    @GetMapping("categoria/{id_categoria}")
    public ResponseEntity<List<Vacante>> filtroCategoria(@PathVariable int id_categoria){
        return (new ResponseEntity<>(vacanteService.buscarPorCategoria(id_categoria),HttpStatus.OK));
    }



}

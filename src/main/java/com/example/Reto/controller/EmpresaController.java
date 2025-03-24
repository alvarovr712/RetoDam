package com.example.Reto.controller;

import com.example.Reto.model.Empresa;
import com.example.Reto.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;


    @PostMapping("nuevo")
    public String altaEmpresa(@RequestBody Empresa empresa) {

        empresaService.altaEmpresa(empresa);
        return "La empresa a sido dada de alta correctamente";

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Empresa>> buscarEmpresaPorId(@PathVariable int id) {


        return (new ResponseEntity<>(empresaService.buscarEmpresaPorId(id), HttpStatus.OK));

    }

    @GetMapping
    public  ResponseEntity<List<Empresa>> buscarTodas(){
        return (new ResponseEntity<>(empresaService.buscarTodas(),HttpStatus.OK));
    }
    @PutMapping("/modificar/{id}")

        public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable int id,@RequestBody Empresa empresa){
            return (new ResponseEntity<>(empresaService.actualizarEmpresa(id,empresa),HttpStatus.OK));
    }


    @DeleteMapping("retirar/{id}")
        public ResponseEntity<String>eliminarEmpresa(@PathVariable int id){
            return(new ResponseEntity<>(empresaService.eliminarEmpresa(id),HttpStatus.OK));
        }
    }



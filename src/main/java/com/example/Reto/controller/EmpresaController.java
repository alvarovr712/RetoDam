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


    @PostMapping("nuevaempresa")
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
    //Actualizar Pais
    @PutMapping("/pais/{id_empresa}")
    public ResponseEntity<Empresa> actualizarPais(@PathVariable int id_empresa,@RequestParam String nuevoPais){
        return (new ResponseEntity<>(empresaService.actualizarPais(id_empresa,nuevoPais),HttpStatus.OK));
    }
    //Actualizar direccion_social
    @PutMapping("/direccion/{id_empresa}")
    public ResponseEntity<Empresa>actualizarDireccion(@PathVariable int id_empresa,@RequestParam String direccion_social){
        return (new ResponseEntity<>(empresaService.actualizarDireccion(id_empresa,direccion_social),HttpStatus.OK));
    }

    @PutMapping("/razon/{id_empresa}")
    public ResponseEntity<Empresa>actualizarRazonSocial(@PathVariable int id_empresa,@RequestParam String razon_social){
        return (new ResponseEntity<>(empresaService.actualizarRazonSocial(id_empresa,razon_social),HttpStatus.OK));
    }

}

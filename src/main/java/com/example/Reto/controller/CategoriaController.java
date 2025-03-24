package com.example.Reto.controller;


import com.example.Reto.model.Categoria;
import com.example.Reto.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
// -------------- ADMINISTRADOR --------------
    //Crear Categoria
  @PostMapping("nuevo")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody  Categoria categoria){
      return (new ResponseEntity<>(categoriaService.nuevaCaterogia(categoria), HttpStatus.OK));
  }

  //Buscar Categoria Por Id

  @GetMapping("{id}")
  public ResponseEntity<Optional<Categoria>> buscarPorId(@PathVariable int id){
      return (new ResponseEntity<>(categoriaService.buscarPorId(id),HttpStatus.OK));
  }

  //Buscar todas las Categorias

 @GetMapping
 public ResponseEntity<List<Categoria>> buscarTodas(){
      return new ResponseEntity<>(categoriaService.buscarTodas(),HttpStatus.OK);
 }

 //Modificar Categoria

 @PutMapping("modificar/{id}")
    public ResponseEntity<Categoria> modificarCategoria(@PathVariable int id, @RequestBody Categoria categoria){
      return (new ResponseEntity<>(categoriaService.acutalizarCaterogia(id,categoria),HttpStatus.OK));
 }

 //Eliminar Categoria

 @DeleteMapping("retirar/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable int id){
      return (new ResponseEntity<>(categoriaService.eliminarCategoria(id),HttpStatus.OK));
 }


}

package com.example.Reto.controller;

import com.example.Reto.model.Usuario;
import com.example.Reto.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
// --------------- ADMINISTRADOR y USUARIO -------------------

    //Solo se pueden Crear usuarios de tipo USUARIO -> 3 y tipo EMPRESA -> 2
    @PostMapping("registro/{id}")
    public ResponseEntity<Usuario> registrarUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        return (new ResponseEntity<>(usuarioService.crearUsuario(id,usuario), HttpStatus.OK));
    }
// ---------------- ADMINISTRADOR ------------------------
    //Asignar a un Usuario el perfil ADMIN

    @PutMapping({"asignar/{username}"})
    public ResponseEntity<Usuario> asignarAdmin(@PathVariable String username){
        return (new ResponseEntity<>(usuarioService.asignarAdmin(username),HttpStatus.OK));
    }

    //Buscar usuario por username
    @GetMapping("{username}")
    public ResponseEntity<Usuario> buscarPorUsername(@PathVariable String username){
        return (new ResponseEntity<>(usuarioService.buscarUsuarioPorUsername(username),HttpStatus.OK));
    }

    //Buscar todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos(){
        return (new ResponseEntity<>(usuarioService.buscarTodos(),HttpStatus.OK));
    }

    //Crear Admin
    @PostMapping("nuevo")
    public ResponseEntity<Usuario> crearAdmin(@RequestBody Usuario usuario){
        return (new ResponseEntity<>(usuarioService.crearAdmin(usuario),HttpStatus.OK));
    }

    //Modificar Usuario
    @PutMapping("modificar/{username}")
    public ResponseEntity<Usuario> modificarUsuario(@PathVariable String username,@RequestBody Usuario usuario){
        return (new ResponseEntity<>(usuarioService.modificarUsuario(username,usuario),HttpStatus.OK));
    }

    //Dar de baja usuario
    @PutMapping("desactivar/{username}")
    public ResponseEntity<Usuario> bajaUsuario(@PathVariable String username){
        return (new ResponseEntity<>(usuarioService.darBajaUsuario(username),HttpStatus.OK));
    }

    //Dar de alta usuario

    @PutMapping("activar/{username}")
    public ResponseEntity<Usuario> altaUsuario(@PathVariable String username){
        return (new ResponseEntity<>(usuarioService.darAltaUsuario(username),HttpStatus.OK));
    }


    //Login
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario){
        return (new ResponseEntity<>(usuarioService.autentificar(usuario),HttpStatus.OK));
    }

    //Crear usuario con el perfil de usuario
    @PostMapping("registro")
    public ResponseEntity<Usuario> CrearUsuarioConPerfil(@RequestBody Usuario usuario){
        return (new ResponseEntity<>(usuarioService.crearUsuarioConPerfil(usuario),HttpStatus.OK));
    }






}

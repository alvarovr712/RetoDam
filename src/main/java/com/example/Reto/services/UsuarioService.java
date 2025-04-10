package com.example.Reto.services;

import com.example.Reto.model.Usuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioService {

    //-------- ADMINISTRADOR --------------

    public Usuario crearUsuario(int id_perfil,Usuario usuario);
    public Usuario asignarAdmin(String username);
    public Usuario buscarUsuarioPorUsername(String username);
    public List<Usuario> buscarTodos();
    public Usuario crearAdmin(Usuario usuario);
    public Usuario modificarUsuario(String username,Usuario nuevousuario);
    public Usuario darBajaUsuario(String username);
    public Usuario darAltaUsuario(String username);
    public ResponseEntity<?> autentificar(Usuario usuario);
    public Usuario crearUsuarioConPerfil(Usuario usuario);



}

package com.example.Reto.services;

import com.example.Reto.model.Perfil;
import com.example.Reto.model.Usuario;
import com.example.Reto.repository.PerfilRepository;
import com.example.Reto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerfilRepository perfilRepository;

    List<Perfil> perfiles = new ArrayList<>();

    //-------------- ADMINISTRADOR y USUARIO-----------------------

    //Solo se pueden crear usuarios de tipo USUARIO y de tipo EMPRESA
    @Override
    public Usuario crearUsuario(int id_perfil,Usuario usuario) {

        Perfil perfilUsuario = perfilRepository.findById(id_perfil).orElse(null);

        if(perfilUsuario != null && id_perfil != 1){
            usuario.setActivado(true);
            usuario.setFecha_registro(LocalDate.now());

            perfiles.add(perfilUsuario);
            usuario.setPerfiles(perfiles);
            return usuarioRepository.save(usuario);
        }else {
            return null;
        }
    // -------------   ADMINISTRADOR ----------------------

    }
    //Asignar a un usuario la categoria de ADMIN
    @Override
    public Usuario asignarAdmin(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        Perfil perfil = perfilRepository.findById(1).orElse(null);

        if(username != null && perfil != null){

            perfiles.add(perfil);
            usuario.setPerfiles(perfiles);
            return usuarioRepository.save(usuario);

        }else {
            return null;
        }
    }
    //Buscar usuario por username
    @Override
    public Usuario buscarUsuarioPorUsername(String username) {
        Usuario usuario =  usuarioRepository.findByUsername(username);

        if(usuario != null){
            Usuario usuario1 = new Usuario();
            usuario1.setUsername(usuario.getUsername());
            usuario1.setNombre(usuario.getNombre());
            usuario1.setApellidos(usuario.getApellidos());
            usuario1.setEmail(usuario.getEmail());
            usuario1.setActivado(usuario.isActivado());
            usuario1.setFecha_registro(usuario.getFecha_registro());
            return usuario1;
        }else {
            return null;
        }


    }

    @Override
    public List<Usuario> buscarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<Usuario> usuariosSinContraseña = new ArrayList<>();

        for (Usuario item : usuarios){
            Usuario usuario1 = new Usuario();

            // Asignamos todas las propiedades excepto la contraseña
            usuario1.setUsername(item.getUsername());
            usuario1.setNombre(item.getNombre());
            usuario1.setApellidos(item.getApellidos());
            usuario1.setEmail(item.getEmail());
            usuario1.setActivado(item.isActivado());
            usuario1.setFecha_registro(item.getFecha_registro());

            usuariosSinContraseña.add(usuario1);
        }
        return usuariosSinContraseña;
    }
    //Crear Admin
    @Override
    public Usuario crearAdmin(Usuario usuario) {
        Perfil perfilAdmin = perfilRepository.findById(3).orElse(null);

        usuario.setActivado(true);
        usuario.setFecha_registro(LocalDate.now());

        perfiles.add(perfilAdmin);
        usuario.setPerfiles(perfiles);
        return usuarioRepository.save(usuario);
    }
    //Modificar Usuario(Se puede modificar el nombre, apellidos, email y password)
    @Override
    public Usuario modificarUsuario(String username, Usuario nuevousuario) {
        Usuario usuario = usuarioRepository.findByUsername(username);

        if(usuario != null){

            if(nuevousuario.getNombre() != null){
                usuario.setNombre(nuevousuario.getNombre());
            }
            if(nuevousuario.getApellidos() != null){
                usuario.setApellidos(nuevousuario.getApellidos());
            }
            if(nuevousuario.getEmail() != null){
                usuario.setEmail(nuevousuario.getEmail());
            }
            if(nuevousuario.getPassword() != null){
                usuario.setPassword(nuevousuario.getPassword());
            }

            return usuarioRepository.save(usuario);
        }else {
            return null;
        }

    }
    // Dar de Baja Usuario
    @Override
    public Usuario darBajaUsuario(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if(username != null){

            usuario.setActivado(false);
            return usuarioRepository.save(usuario);
        }else {
            return null;
        }
    }

    @Override
    public Usuario darAltaUsuario(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if(username != null){
            usuario.setActivado(true);
            return usuarioRepository.save(usuario);
        }else {
            return null;
        }
    }


}

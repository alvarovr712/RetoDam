package com.example.Reto.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_perfil;

    @Column
    private String nombre;

    @ManyToMany(mappedBy = "perfiles",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Usuario> usuarios;

    public Perfil() {
    }

    public Perfil(String nombre, List<Usuario> usuarios, int id_perfil) {
        this.nombre = nombre;
        this.usuarios = usuarios;
        this.id_perfil = id_perfil;
    }

    public Perfil(String nombre) {
        this.nombre = nombre;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id_perfil=" + id_perfil +
                ", nombre='" + nombre + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}

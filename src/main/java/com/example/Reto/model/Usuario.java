package com.example.Reto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column
    private String username;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private boolean activado;

    @Column
    private LocalDate fecha_registro;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Solicitud> solicitudes;

    @ManyToMany
    @JoinTable(
            name = "usuarioperfil",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "id_perfil")

    )
    @JsonIgnore
    private List<Perfil> perfiles;
    @OneToOne(mappedBy = "responsable",fetch = FetchType.LAZY)
    private Empresa empresa;

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Usuario() {
    }

    public Usuario(String username) {
        this.username = username;
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Usuario(String username, LocalDate fecha_registro, boolean activado, String password, String email, String apellidos, String nombre) {
        this.username = username;
        this.fecha_registro = fecha_registro;
        this.activado = activado;
        this.password = password;
        this.email = email;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    public Usuario(String username, List<Perfil> perfiles, List<Solicitud> solicitudes, LocalDate fecha_registro, boolean activado, String password, String email, String apellidos, String nombre) {
        this.username = username;
        this.perfiles = perfiles;
        this.solicitudes = solicitudes;
        this.fecha_registro = fecha_registro;
        this.activado = activado;
        this.password = password;
        this.email = email;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    public Usuario(String username, String nombre, String apellidos, String email, String password, LocalDate fecha_registro) {
        this.username = username;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.fecha_registro = fecha_registro;
    }

    public Usuario(String username, String nombre, String apellidos, String email, String password) {
        this.username = username;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", activado=" + activado +
                ", fecha_registro=" + fecha_registro +
                ", solicitudes=" + solicitudes +
                ", perfiles=" + perfiles +
                '}';
    }
}

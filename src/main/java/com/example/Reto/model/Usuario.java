package com.example.Reto.model;

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
    private char password;

    @Column
    private Boolean activado;

    @Column
    private LocalDate fecha_registro;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Solicitud> solicitudes;

    @ManyToMany
    @JoinTable(
            name = "usuarioperfil",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "id_perfil")

    )
    private List<Perfil> perfiles;

    public Usuario() {
    }

    public Usuario(String username, List<Perfil> perfiles, List<Solicitud> solicitudes, LocalDate fecha_registro, Boolean activado, char password, String email, String apellidos, String nombre) {
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

    public Usuario(String email, char password) {
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

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Boolean getActivado() {
        return activado;
    }

    public void setActivado(Boolean activado) {
        this.activado = activado;
    }

    public char getPassword() {
        return password;
    }

    public void setPassword(char password) {
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
                ", password=" + password +
                ", activado=" + activado +
                ", fecha_registro=" + fecha_registro +
                ", solicitudes=" + solicitudes +
                ", perfiles=" + perfiles +
                '}';
    }
}

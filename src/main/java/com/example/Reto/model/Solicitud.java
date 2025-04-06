package com.example.Reto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_solicitud;

    @Column
    private LocalDate fecha;


    @Column
    private String archivo;

    @Column(name = "comentarios")
    private String comentario;

    @Column
    private int estado;

    @ManyToOne()
    @JoinColumn(name = "id_vacante")
    private Vacante vacante;

    @ManyToOne()
    @JoinColumn(name = "username")
    private Usuario usuario;

    public Solicitud() {
    }

    public Solicitud(int id_solicitud, LocalDate fecha, String archivo, String comentario, int estado, Vacante vacante, Usuario usuario) {
        this.id_solicitud = id_solicitud;
        this.fecha = fecha;
        this.archivo = archivo;
        this.comentario = comentario;
        this.estado = estado;
        this.vacante = vacante;
        this.usuario = usuario;
    }

    public Solicitud(LocalDate fecha, String archivo, String comentario, int estado) {
        this.fecha = fecha;
        this.archivo = archivo;
        this.comentario = comentario;
        this.estado = estado;
    }

    public Solicitud(String archivo, String comentario, Vacante vacante, Usuario usuario) {
        this.archivo = archivo;
        this.comentario = comentario;
        this.vacante = vacante;
        this.usuario = usuario;
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vacante getVacante() {
        return vacante;
    }

    public void setVacante(Vacante vacante) {
        this.vacante = vacante;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "id_solicitud=" + id_solicitud +
                ", fecha=" + fecha +
                ", archivo='" + archivo + '\'' +
                ", comentario='" + comentario + '\'' +
                ", estado=" + estado +
                ", vacante=" + vacante +
                ", usuario=" + usuario +
                '}';
    }
}

package com.example.Reto.model;

import java.time.LocalDate;

public class VacanteDTO {

    private int id_vacante;
    private String nombre;
    private String descripcion;
    private LocalDate fecha;
    private Double salario;
    private Boolean destacado;
    private String imagen;
    private String detalles;
    private String razonSocial;
    private String categoria;

    public VacanteDTO(int id_vacante, String nombre, String descripcion, LocalDate fecha, Double salario, Boolean destacado, String imagen, String detalles, String razonSocial, String categoria) {
        this.id_vacante = id_vacante;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.salario = salario;
        this.destacado = destacado;
        this.imagen = imagen;
        this.detalles = detalles;
        this.razonSocial = razonSocial;
        this.categoria = categoria;
    }

    public int getId_vacante() {
        return id_vacante;
    }

    public void setId_vacante(int id_vacante) {
        this.id_vacante = id_vacante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Boolean getDestacado() {
        return destacado;
    }

    public void setDestacado(Boolean destacado) {
        this.destacado = destacado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

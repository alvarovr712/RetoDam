package com.example.Reto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Table
@Entity(name = "vacante")
public class Vacante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_vacante;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private LocalDate fecha;

    @Column
    private Double salario;

    @Column
    private Boolean destacado;

    @Column
    private String imagen;

    @Column
    private String detalles;

    /*La creacion del enum en JPA para poder mapearlo tienes que definir el enum y sus fases en este caso CREADA y CANCELADA y ASIGNADA, en nuestro valor estatus
    * debemos poner el decorador @Enumerated y el tipo de Enumerated que queremos en este caso String*/

    @Column
    @Enumerated(EnumType.STRING)
    private Estatus estatus = Estatus.CREADA;

    public enum Estatus{
        CREADA,
        CANCELADA,
        ASIGNADA
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_empresa")
    @JsonIgnore
    private Empresa empresa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_categoria")
    @JsonIgnore
    private Categoria categoria;

    //He tenido que poner el fetch en Lazy porque al intentar cambiar el estatus de la vacante me daba error con el EAGER
    @OneToMany(mappedBy = "vacante",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Solicitud> solicitudes;

    public Vacante() {
    }

    public Vacante(int id_vacante, List<Solicitud> solicitudes, Categoria categoria, Empresa empresa, Estatus estatus, String imagen, String detalles, Boolean destacado, Double salario, LocalDate fecha, String descripcion, String nombre) {
        this.id_vacante = id_vacante;
        this.solicitudes = solicitudes;
        this.categoria = categoria;
        this.empresa = empresa;
        this.estatus = estatus;
        this.imagen = imagen;
        this.detalles = detalles;
        this.destacado = destacado;
        this.salario = salario;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Vacante(String nombre, String descripcion, LocalDate fecha, Double salario, Boolean destacado, String imagen, String detalles) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.salario = salario;
        this.destacado = destacado;
        this.imagen = imagen;
        this.detalles = detalles;
    }

    public Vacante(String nombre, String descripcion, Double salario, Boolean destacado, String imagen, String detalles) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.salario = salario;
        this.destacado = destacado;
        this.imagen = imagen;
        this.detalles = detalles;
    }

    public Vacante(String nombre, String descripcion, Double salario, String detalles, String imagen, Empresa empresa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.salario = salario;
        this.detalles = detalles;
        this.imagen = imagen;
        this.empresa = empresa;
    }

    public Vacante(String nombre) {
        this.nombre = nombre;
    }

    public int getId_vacante() {
        return id_vacante;
    }

    public void setId_vacante(int id_vacante) {
        this.id_vacante = id_vacante;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean getDestacado() {
        return destacado;
    }

    public void setDestacado(Boolean destacado) {
        this.destacado = destacado;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Vacante{" +
                "id_vacante=" + id_vacante +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", salario=" + salario +
                ", destacado=" + destacado +
                ", imagen='" + imagen + '\'' +
                ", detalles='" + detalles + '\'' +
                ", estatus=" + estatus +
                ", empresa=" + empresa +
                ", categoria=" + categoria +
                ", solicitudes=" + solicitudes +
                '}';
    }
}

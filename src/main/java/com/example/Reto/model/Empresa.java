package com.example.Reto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_empresa;

    @Column
    private String razon_social;

    @Column
    private String direccion_social;

    @Column
    private String pais;



    @OneToMany(mappedBy = "empresa",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Vacante> vacantes;

    @OneToOne
    @JoinColumn(name = "responsable",referencedColumnName = "username")
    private Usuario responsable;


    public Empresa() {
    }

    public Empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public Empresa(int id_empresa, String razon_social, String direccion_social, String pais, List<Vacante> vacantes, Usuario responsable) {
        this.id_empresa = id_empresa;
        this.razon_social = razon_social;
        this.direccion_social = direccion_social;
        this.pais = pais;
        this.vacantes = vacantes;
        this.responsable = responsable;
    }

    public Empresa(String razon_social, String direccion_social, String pais) {
        this.razon_social = razon_social;
        this.direccion_social = direccion_social;
        this.pais = pais;
    }

    public Empresa(String razon_social, String direccion_social, String pais, Usuario responsable) {
        this.razon_social = razon_social;
        this.direccion_social = direccion_social;
        this.pais = pais;
        this.responsable = responsable;
    }



    public Usuario getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion_social() {
        return direccion_social;
    }

    public void setDireccion_social(String direccion_social) {
        this.direccion_social = direccion_social;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Vacante> getVacantes() {
        return vacantes;
    }

    public void setVacantes(List<Vacante> vacantes) {
        this.vacantes = vacantes;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id_empresa=" + id_empresa +
                ", razon_social='" + razon_social + '\'' +
                ", direccion_social='" + direccion_social + '\'' +
                ", pais='" + pais + '\'' +
                ", vacantes=" + vacantes +
                ", responsable=" + responsable +
                '}';
    }
}

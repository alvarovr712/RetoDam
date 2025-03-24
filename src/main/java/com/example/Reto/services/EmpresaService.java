package com.example.Reto.services;

import com.example.Reto.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {


    // ------------------  ADMINISTRADOR --------------------
    public Empresa altaEmpresa(Empresa empresa);
    public Optional<Empresa> buscarEmpresaPorId(int id_empresa);
    public List<Empresa> buscarTodas();
    public Empresa actualizarEmpresa(int id_empresa, Empresa empresa);
    public String eliminarEmpresa(int id_empresa);
}

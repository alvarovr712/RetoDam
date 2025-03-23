package com.example.Reto.services;

import com.example.Reto.model.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {


    // ------------------  ADMINISTRADOR --------------------
    public Empresa altaEmpresa(Empresa empresa);
    public Optional<Empresa> buscarEmpresaPorId(int id_empresa);
    public List<Empresa> buscarTodas();
    public Empresa actualizarPais(int id_empresa,String nuevo_pais);
    public Empresa actualizarDireccion(int id_empresa,String nueva_direccion);
    public Empresa actualizarRazonSocial(int id_empresa,String nueva_razon_social);
}

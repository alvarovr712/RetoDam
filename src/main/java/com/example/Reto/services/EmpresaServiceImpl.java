package com.example.Reto.services;

import com.example.Reto.model.Empresa;
import com.example.Reto.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService{

    @Autowired
    private EmpresaRepository empresaRepository;

    // --------------   ADMINISTRADOR -----------------------

    @Override
    public Empresa altaEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

        //Buscar empresa por id

    @Override
    public Optional<Empresa> buscarEmpresaPorId(int id_empresa) {
        return empresaRepository.findById(id_empresa);

    }
        //Buscar todas las empresas
    @Override
    public List<Empresa> buscarTodas() {
        return empresaRepository.findAll();
    }
        //Actualizar el pais de la empresa
    @Override
    public Empresa actualizarPais(int id_empresa, String nuevo_pais) {
        Empresa empresa = empresaRepository.findById(id_empresa).orElse(null);

        if(empresa != null){

            empresa.setPais(nuevo_pais);
            empresaRepository.save(empresa);
            return empresa;
        }else {
            return null;
        }
    }

    // Actualizar direccion_social
    @Override
    public Empresa actualizarDireccion(int id_empresa, String nueva_direccion) {
        Empresa empresa = empresaRepository.findById(id_empresa).orElse(null);
        if(empresa != null){
            empresa.setDireccion_social(nueva_direccion);
            empresaRepository.save(empresa);
            return empresa;
        }else {
            return null;
        }
    }
    //Actualizar razon_social
    @Override
    public Empresa actualizarRazonSocial(int id_empresa, String nueva_razon_social) {
        Empresa empresa = empresaRepository.findById(id_empresa).orElse(null);
        if(empresa != null){
            empresa.setRazon_social(nueva_razon_social);
            empresaRepository.save(empresa);
            return empresa;
        }else {
            return null;
        }
    }


}

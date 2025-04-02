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
        //Actualizar empresa(no hace falta meter todos los valores en el body solo el que se quiera actualizar los otros seguiran siendo los mismos una vez se
        //actualice)

    @Override
    public Empresa actualizarEmpresa(int id_empresa, Empresa nuevaempresa) {
        Empresa empresa = empresaRepository.findById(id_empresa).orElse(null);

        if(empresa != null){

            if(nuevaempresa.getRazon_social() != null){
            empresa.setRazon_social(nuevaempresa.getRazon_social());}
            if(nuevaempresa.getDireccion_social() != null){
            empresa.setDireccion_social(nuevaempresa.getDireccion_social());}
            if(nuevaempresa.getPais() != null){
            empresa.setPais(nuevaempresa.getPais());}

            return empresaRepository.save(empresa);
        }else {
            return null;
        }
    }

    //Eliminar empresa
    @Override
    public String eliminarEmpresa(int id_empresa) {
        Empresa empresa = empresaRepository.findById(id_empresa).orElse(null);
        if(empresa != null) {
            empresaRepository.delete(empresa);
            return "La empresa ha sido eliminada correctamente";
        }else {
            return "No se encontró la empresa";
        }
    }


}

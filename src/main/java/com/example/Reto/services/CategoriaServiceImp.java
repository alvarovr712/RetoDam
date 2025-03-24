package com.example.Reto.services;

import com.example.Reto.model.Categoria;
import com.example.Reto.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImp implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;
// ----------- ADMINISTRADOR ---------------

    //Crear Categoria
    @Override
    public Categoria nuevaCaterogia(Categoria categoria) {
        if(categoriaRepository.findByNombre(categoria.getNombre()) == null){
        return categoriaRepository.save(categoria);
        }else {
            return null;
        }
    }
    //Buscar Categoria por Id

    @Override
    public Optional<Categoria> buscarPorId(int id_categoria) {
        return categoriaRepository.findById(id_categoria);
    }

    //Buscar todas las Categorias

    @Override
    public List<Categoria> buscarTodas() {
        return categoriaRepository.findAll();
    }

    //Modificar Categoria (poner el campo que se desea modificar los demas campos al quedaran con los valores anteriores)
    @Override
    public Categoria acutalizarCaterogia(int id_categoria, Categoria nuevacategoria) {
        Categoria categoria = categoriaRepository.findById(id_categoria).orElse(null);

        if(categoria != null){
            if(nuevacategoria.getNombre() != null){
                categoria.setNombre(nuevacategoria.getNombre());
            }
            if(nuevacategoria.getDescripcion() != null){
                categoria.setDescripcion(nuevacategoria.getDescripcion());
            }
            return categoriaRepository.save(categoria);
        }else {
            return null;
        }
    }

    //Eliminar Categoria buscada por Id

    @Override
    public String eliminarCategoria(int id_categoria) {
        Categoria categoria = categoriaRepository.findById(id_categoria).orElse(null);

        if(categoria != null){
            categoriaRepository.delete(categoria);
            return "La categoria ha sido eliminada correctamente";
        }else{
            return "No se encontró la categoria";
        }
    }


}

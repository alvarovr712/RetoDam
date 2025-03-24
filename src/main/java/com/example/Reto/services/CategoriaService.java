package com.example.Reto.services;

import com.example.Reto.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    //----------- ADMINISTRADOR ------------

    public Categoria nuevaCaterogia(Categoria categoria);
    public Optional<Categoria> buscarPorId(int id_categoria);
    public List<Categoria> buscarTodas();
    public Categoria acutalizarCaterogia(int id_categoria,Categoria nuevacategoria);
    public String eliminarCategoria(int id_categoria);
}

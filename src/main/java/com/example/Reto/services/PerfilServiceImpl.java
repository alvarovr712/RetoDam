package com.example.Reto.services;

import com.example.Reto.model.Perfil;
import com.example.Reto.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public Perfil crearPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }
}

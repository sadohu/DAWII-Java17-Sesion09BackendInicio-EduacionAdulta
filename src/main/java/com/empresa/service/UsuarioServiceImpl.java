package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entidades.Pasatiempo;
import com.empresa.entidades.Usuario;
import com.empresa.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> listaUsuario() {
        return repository.findAll();
    }

    @Override
    public List<Pasatiempo> traerPasatiempoDeUsuario(int idUsuario) {
        return repository.traerPasatiempoDeUsuario(idUsuario);
    }

}

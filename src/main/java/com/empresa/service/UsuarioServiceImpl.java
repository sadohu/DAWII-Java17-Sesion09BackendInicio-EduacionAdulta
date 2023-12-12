package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entidades.Pasatiempo;
import com.empresa.entidades.Usuario;
import com.empresa.entidades.UsuarioHasPasatiempo;
import com.empresa.entidades.UsuarioHasPasatiempoPK;
import com.empresa.repository.UsuarioHasPasatiempoRepository;
import com.empresa.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private UsuarioHasPasatiempoRepository repositoryUsuarioHasPasatiempo;

    @Override
    public List<Usuario> listaUsuario() {
        return repository.findAll();
    }

    @Override
    public List<Pasatiempo> traerPasatiempoDeUsuario(int idUsuario) {
        return repository.traerPasatiempoDeUsuario(idUsuario);
    }

    @Override
    public UsuarioHasPasatiempo insertaPasatiempo(UsuarioHasPasatiempo obj) {
        return repositoryUsuarioHasPasatiempo.save(obj);
    }

    @Override
    public void eliminaPasatiempo(UsuarioHasPasatiempo obj) {
        repositoryUsuarioHasPasatiempo.delete(obj);
    }

    @Override
    public Optional<UsuarioHasPasatiempo> buscaPasatiempo(UsuarioHasPasatiempoPK obj) {
        return repositoryUsuarioHasPasatiempo.findById(obj);
    }

}

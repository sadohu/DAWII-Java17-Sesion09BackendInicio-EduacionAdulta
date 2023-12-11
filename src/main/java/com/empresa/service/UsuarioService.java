package com.empresa.service;

import java.util.List;

import com.empresa.entidades.Pasatiempo;
import com.empresa.entidades.Usuario;

public interface UsuarioService {
    public abstract List<Usuario> listaUsuario();

    public abstract List<Pasatiempo> traerPasatiempoDeUsuario(int idUsuario);

}

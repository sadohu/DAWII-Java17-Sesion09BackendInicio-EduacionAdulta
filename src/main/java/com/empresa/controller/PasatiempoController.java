package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entidades.Pasatiempo;
import com.empresa.service.UsuarioService;

@Controller
@RequestMapping("/url/pasatiempo")
public class PasatiempoController {
    @Autowired
    private UsuarioService usuarioService;

    @ResponseBody
    @GetMapping("/listaPasatiempoPorUsuario")
    public List<Pasatiempo> listaPasatiempoPorUsuario(int idUsuario) {
        return usuarioService.traerPasatiempoDeUsuario(idUsuario);
    }

}

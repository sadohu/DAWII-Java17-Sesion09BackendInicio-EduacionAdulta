package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entidades.Pasatiempo;
import com.empresa.entidades.UsuarioHasPasatiempo;
import com.empresa.entidades.UsuarioHasPasatiempoPK;
import com.empresa.service.UsuarioService;
import com.empresa.util.AppSettings;

@Controller
@RequestMapping("/url/pasatiempo")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class PasatiempoController {

    @Autowired
    private UsuarioService usuarioService;

    @ResponseBody
    @GetMapping("/listaPasatiempoPorUsuario/{id}")
    public List<Pasatiempo> listaPasatiempoPorUsuario(@PathVariable("id") int idUsuario) {
        return usuarioService.traerPasatiempoDeUsuario(idUsuario);
    }

    @ResponseBody
    @PostMapping("/registraPasatiempo")
    public HashMap<String, Object> registro(@RequestBody UsuarioHasPasatiempoPK requestObject) {
        HashMap<String, Object> maps = new HashMap<String, Object>();
        UsuarioHasPasatiempoPK pk = new UsuarioHasPasatiempoPK();
        pk.setIdPasatiempo(requestObject.getIdPasatiempo());
        pk.setIdUsuario(requestObject.getIdUsuario());

        UsuarioHasPasatiempo obj = new UsuarioHasPasatiempo();
        obj.setUsuarioHasPasatiempoPK(pk);

        Optional<UsuarioHasPasatiempo> existentPasatiempo = usuarioService.buscaPasatiempo(pk);
        if (existentPasatiempo.isEmpty()) {
            UsuarioHasPasatiempo objSalida = usuarioService.insertaPasatiempo(obj);
            if (objSalida == null) {
                maps.put("mensaje", "Error en el registro");
            } else {
                maps.put("mensaje", "Registro exitoso");
            }
        } else {
            maps.put("mensaje", "Ya existe el pasatiempo");
        }
        List<Pasatiempo> lstPasatiempo = usuarioService.traerPasatiempoDeUsuario(requestObject.getIdUsuario());
        maps.put("lista", lstPasatiempo);
        return maps;
    }

    @ResponseBody
    @PostMapping("/eliminaPasatiempo")
    public HashMap<String, Object> elimina(@RequestBody UsuarioHasPasatiempoPK requestObject) {
        HashMap<String, Object> maps = new HashMap<String, Object>();

        UsuarioHasPasatiempoPK pk = new UsuarioHasPasatiempoPK();
        pk.setIdPasatiempo(requestObject.getIdPasatiempo());
        pk.setIdUsuario(requestObject.getIdUsuario());

        UsuarioHasPasatiempo obj = new UsuarioHasPasatiempo();
        obj.setUsuarioHasPasatiempoPK(pk);

        usuarioService.eliminaPasatiempo(obj);
        maps.put("mensaje", "Eliminación exitosa");

        List<Pasatiempo> lstPasatiempo = usuarioService.traerPasatiempoDeUsuario(requestObject.getIdUsuario());
        maps.put("lista", lstPasatiempo);

        return maps;
    }

}

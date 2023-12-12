package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entidades.UsuarioHasPasatiempo;
import com.empresa.entidades.UsuarioHasPasatiempoPK;

public interface UsuarioHasPasatiempoRepository extends JpaRepository<UsuarioHasPasatiempo, UsuarioHasPasatiempoPK> {

}

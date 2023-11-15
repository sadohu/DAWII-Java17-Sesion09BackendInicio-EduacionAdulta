package com.empresa.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.empresa.entidades.Producto;

public interface ProductoService {

	public List<Producto> listaproducto(String filtro, Pageable pageable);

}

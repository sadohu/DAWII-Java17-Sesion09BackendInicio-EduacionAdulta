package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.entidades.Boleta;
import com.empresa.entidades.BoletaHasProducto;
import com.empresa.repository.BoletaHasProductoRepository;
import com.empresa.repository.BoletaRepository;

@Service
public class BoletaServiceImpl implements BoletaService{

	@Autowired
	private BoletaRepository boletaRepository;
	
	@Autowired
	private BoletaHasProductoRepository detalleRepository;
	
	@Override
	@Transactional
	public Boleta insertaBoleta(Boleta obj) {
		Boleta cabecera = boletaRepository.save(obj);
		for (BoletaHasProducto d : cabecera.getDetallesBoleta()) {
			d.getBoletaHasProductoPK().setIdBoleta(cabecera.getIdboleta());
			detalleRepository.actualizaStock(d.getCantidad(), d.getBoletaHasProductoPK().getIdProducto());
			detalleRepository.save(d);
		}
		return cabecera;
	}

	@Override
	public List<Boleta> listaBoleta() {
		return boletaRepository.findAll();
	}

}

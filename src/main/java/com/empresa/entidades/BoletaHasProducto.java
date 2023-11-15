package com.empresa.entidades;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "boleta_has_producto")
public class BoletaHasProducto {

	@EmbeddedId
	private BoletaHasProductoPK boletaHasProductoPK;
	private double precio;
	private int cantidad;

	@ManyToOne
	@JoinColumn(name = "idboleta", nullable = false, insertable = false, updatable = false)
	private Boleta boleta;

	@ManyToOne
	@JoinColumn(name = "idproducto", nullable = false, insertable = false, updatable = false)
	private Producto producto;

}

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
@Table(name = "usuario_has_pasatiempo")
public class UsuarioHasPasatiempo {

	@EmbeddedId
	private UsuarioHasPasatiempoPK usuarioHasPasatiempoPK;

	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idPasatiempo", nullable = false, insertable = false, updatable = false)
	private Pasatiempo pasatiempo;

}

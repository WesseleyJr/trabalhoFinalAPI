package br.org.serratec.redesocial.dto;

import java.time.LocalDate;
import java.util.Objects;

import br.org.serratec.redesocial.domain.Usuario;

public class SeguidorDTO {
	
	private Long id;
	private LocalDate dataInicioSeguimento;
	private Usuario usuarioSeguidor;
	private Usuario usuarioSeguido;

	public SeguidorDTO() {
	}

	public SeguidorDTO(Long id, LocalDate dataInicioSeguimento, Usuario usuarioSeguidor, Usuario usuarioSeguido) {
		super();
		this.id = id;
		this.dataInicioSeguimento = dataInicioSeguimento;
		this.usuarioSeguidor = usuarioSeguidor;
		this.usuarioSeguido = usuarioSeguido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataInicioSeguimento() {
		return dataInicioSeguimento;
	}

	public void setDataInicioSeguimento(LocalDate dataInicioSeguimento) {
		this.dataInicioSeguimento = dataInicioSeguimento;
	}

	public Usuario getUsuarioSeguidor() {
		return usuarioSeguidor;
	}

	public void setUsuarioSeguidor(Usuario usuarioSeguidor) {
		this.usuarioSeguidor = usuarioSeguidor;
	}

	public Usuario getUsuarioSeguido() {
		return usuarioSeguido;
	}

	public void setUsuarioSeguido(Usuario usuarioSeguido) {
		this.usuarioSeguido = usuarioSeguido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataInicioSeguimento, id, usuarioSeguido, usuarioSeguidor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeguidorDTO other = (SeguidorDTO) obj;
		return Objects.equals(dataInicioSeguimento, other.dataInicioSeguimento) && Objects.equals(id, other.id)
				&& Objects.equals(usuarioSeguido, other.usuarioSeguido)
				&& Objects.equals(usuarioSeguidor, other.usuarioSeguidor);
	}

}

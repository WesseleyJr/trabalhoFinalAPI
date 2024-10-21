package br.org.serratec.redesocial.dto;

import java.time.LocalDate;

<<<<<<< HEAD
import br.org.serratec.redesocial.domain.Seguidor;
=======
import br.org.serratec.redesocial.domain.Relacionamento;
import br.org.serratec.redesocial.domain.Usuario;
>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b

public class SeguidorDTO {

	private Long id;
	private LocalDate dataInicioSeguimento;
	private Long idUsuarioSeguidor;
	private Long idUsuarioSeguido;

	public SeguidorDTO() {
	}

<<<<<<< HEAD
	public SeguidorDTO(Seguidor seguidor) {
		this.id = seguidor.getId();
		this.dataInicioSeguimento = seguidor.getDataInicioSeguimento();
		this.idUsuarioSeguidor = seguidor.getUsuarioSeguidor().getId();
		this.idUsuarioSeguido = seguidor.getUsuarioSeguido().getId();
	}

	public SeguidorDTO(Long id, LocalDate dataInicioSeguimento, Long idUsuarioSeguidor, Long idUsuarioSeguido) {
		super();
=======
	public SeguidorDTO(Long id, LocalDate dataInicioSeguimento, Usuario usuarioSeguidor, Usuario usuarioSeguido) {
>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b
		this.id = id;
		this.dataInicioSeguimento = dataInicioSeguimento;
		this.idUsuarioSeguidor = idUsuarioSeguidor;
		this.idUsuarioSeguido = idUsuarioSeguido;
	}

	public SeguidorDTO(Relacionamento relacionamento) {
		this.id = relacionamento.getId();
		this.dataInicioSeguimento = relacionamento.getDataInicioSeguimento();
		this.usuarioSeguidor = relacionamento.getUsuarioSeguidor();
		this.usuarioSeguido = relacionamento.getUsuarioSeguido();
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

	public Long getIdUsuarioSeguidor() {
		return idUsuarioSeguidor;
	}

	public void setIdUsuarioSeguidor(Long idUsuarioSeguidor) {
		this.idUsuarioSeguidor = idUsuarioSeguidor;
	}

	public Long getIdUsuarioSeguido() {
		return idUsuarioSeguido;
	}

	public void setIdUsuarioSeguido(Long idUsuarioSeguido) {
		this.idUsuarioSeguido = idUsuarioSeguido;
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b

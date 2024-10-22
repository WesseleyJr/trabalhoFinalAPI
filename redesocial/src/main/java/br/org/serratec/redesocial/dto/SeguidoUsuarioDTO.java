package br.org.serratec.redesocial.dto;

import java.util.ArrayList;
import java.util.List;

import br.org.serratec.redesocial.domain.Seguidor;

public class SeguidoUsuarioDTO {

	private String nomeUsuarioSeguido;
	private Long idUsuarioSeguido;
	private String sobrenomeUsuarioSeguido;
	private List<SeguidorUsuarioDTO> seguidores;

	public SeguidoUsuarioDTO() {
	}

	public SeguidoUsuarioDTO(Seguidor seguidor) {
		this.nomeUsuarioSeguido = seguidor.getUsuarioSeguido().getNome();
		this.idUsuarioSeguido = seguidor.getUsuarioSeguido().getId();
		this.sobrenomeUsuarioSeguido = seguidor.getUsuarioSeguido().getSobrenome();
		this.seguidores = new ArrayList<>();
		for (Seguidor s : seguidor.getUsuarioSeguido().getSeguidores()) {
			this.seguidores.add(new SeguidorUsuarioDTO(s));
		}
	}

	public String getNomeUsuarioSeguido() {
		return nomeUsuarioSeguido;
	}

	public void setNomeUsuarioSeguido(String nomeUsuarioSeguido) {
		this.nomeUsuarioSeguido = nomeUsuarioSeguido;
	}

	public Long getIdUsuarioSeguido() {
		return idUsuarioSeguido;
	}

	public void setIdUsuarioSeguido(Long idUsuarioSeguido) {
		this.idUsuarioSeguido = idUsuarioSeguido;
	}

	public String getSobrenomeUsuarioSeguido() {
		return sobrenomeUsuarioSeguido;
	}

	public void setSobrenomeUsuarioSeguido(String sobrenomeUsuarioSeguido) {
		this.sobrenomeUsuarioSeguido = sobrenomeUsuarioSeguido;
	}

	public List<SeguidorUsuarioDTO> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(List<SeguidorUsuarioDTO> seguidores) {
		this.seguidores = seguidores;
	}

}

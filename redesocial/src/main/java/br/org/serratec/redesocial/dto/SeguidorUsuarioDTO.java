package br.org.serratec.redesocial.dto;

import br.org.serratec.redesocial.domain.Seguidor;

public class SeguidorUsuarioDTO {

	private String nomeUsuarioSeguidor;
	private Long idUsuarioSeguidor;
	private String sobrenomeUsuarioSeguidor;

	public SeguidorUsuarioDTO() {
	}

	public SeguidorUsuarioDTO(Seguidor seguidor) {
		this.nomeUsuarioSeguidor = seguidor.getUsuarioSeguidor().getNome();
		this.idUsuarioSeguidor = seguidor.getUsuarioSeguidor().getId();
		this.sobrenomeUsuarioSeguidor = seguidor.getUsuarioSeguidor().getSobrenome();
	}

	public String getNomeUsuarioSeguidor() {
		return nomeUsuarioSeguidor;
	}

	public void setNomeUsuarioSeguidor(String nomeUsuarioSeguidor) {
		this.nomeUsuarioSeguidor = nomeUsuarioSeguidor;
	}

	public Long getIdUsuarioSeguidor() {
		return idUsuarioSeguidor;
	}

	public void setIdUsuarioSeguidor(Long idUsuarioSeguidor) {
		this.idUsuarioSeguidor = idUsuarioSeguidor;
	}

	public String getSobrenomeUsuarioSeguidor() {
		return sobrenomeUsuarioSeguidor;
	}

	public void setSobrenomeUsuarioSeguidor(String sobrenomeUsuarioSeguidor) {
		this.sobrenomeUsuarioSeguidor = sobrenomeUsuarioSeguidor;
	}

}

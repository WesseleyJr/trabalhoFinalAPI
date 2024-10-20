package br.org.serratec.redesocial.dto;

import java.time.LocalDate;

import br.org.serratec.redesocial.domain.Comentario;

public class ComentarioInserirDTO {

	private Long id;
	private String texto;
	private Long idUsuario;
	private Long idPost;
	private LocalDate dataComentario;

	public ComentarioInserirDTO() {
	}

	public ComentarioInserirDTO(Comentario comentario) {
		this.id = comentario.getId();
		this.texto = comentario.getTexto();
		this.idUsuario = comentario.getUsuario().getId();
		this.idPost = comentario.getPost().getId();
		this.dataComentario = comentario.getDataComentario();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	public LocalDate getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(LocalDate dataComentario) {
		this.dataComentario = dataComentario;
	}

}

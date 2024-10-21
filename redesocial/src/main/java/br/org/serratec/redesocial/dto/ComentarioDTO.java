package br.org.serratec.redesocial.dto;

import java.time.LocalDate;

import br.org.serratec.redesocial.domain.Comentario;

public class ComentarioDTO {

	private Long id;
	private String texto;
	private String nomeUsuario;
	private Long idPost;
	private LocalDate dataComentario;
<<<<<<< HEAD
=======
	private String nomeUsuario;

	public ComentarioDTO(Comentario comentario) {
		this.id = comentario.getId();
		this.texto = comentario.getTexto();
		this.dataComentario = comentario.getDataComentario();
		this.nomeUsuario = comentario.getUsuario().getNome();
	}
>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b

	public ComentarioDTO() {

	}

<<<<<<< HEAD
	public ComentarioDTO(Comentario comentario) {
		this.id = comentario.getId();
		this.texto = comentario.getTexto();
		this.nomeUsuario = comentario.getUsuario().getNome();
		this.idPost = comentario.getPost().getId();
		this.dataComentario = comentario.getDataComentario();
	}

=======
>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b
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

	public LocalDate getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(LocalDate dataComentario) {
		this.dataComentario = dataComentario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
<<<<<<< HEAD
=======
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

}
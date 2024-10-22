package br.org.serratec.redesocial.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.org.serratec.redesocial.domain.Comentario;
import br.org.serratec.redesocial.domain.Post;

public class PostDTO {

	private Long id;
	private String conteudo;
	private LocalDate dataCriacao;
	private String usuarioNome;
	private List<ComentarioDTO> comentarios;

	public PostDTO() {
	}

	public PostDTO(Post post) {
		this.id = post.getId();
		this.conteudo = post.getConteudo();
		this.dataCriacao = post.getDataCriacao();
		this.usuarioNome = post.getUsuario().getNome();
		this.comentarios = new ArrayList<>();
		for (Comentario comentario : post.getComentarios()) {
			this.comentarios.add(new ComentarioDTO(comentario));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<ComentarioDTO> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioDTO> comentarios) {
		this.comentarios = comentarios;
	}

	public String getUsuarioNome() {
		return usuarioNome;
	}

	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}

}

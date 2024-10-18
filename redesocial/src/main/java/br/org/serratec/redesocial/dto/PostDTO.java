package br.org.serratec.redesocial.dto;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import br.org.serratec.redesocial.domain.Comentario;

public class PostDTO {
	
	private Long id;
	private String conteudo;
	private LocalDate dataCriacao;
	private Set <Comentario> comentarios;
	
	public PostDTO(Long id, String conteudo, LocalDate dataCriacao, Set<Comentario> comentarios) {
		super();
		this.id = id;
		this.conteudo = conteudo;
		this.dataCriacao = dataCriacao;
		this.comentarios = comentarios;
	}
	
	public PostDTO() {
		
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

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comentarios, conteudo, dataCriacao, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostDTO other = (PostDTO) obj;
		return Objects.equals(comentarios, other.comentarios) && Objects.equals(conteudo, other.conteudo)
				&& Objects.equals(dataCriacao, other.dataCriacao) && Objects.equals(id, other.id);
	}

}

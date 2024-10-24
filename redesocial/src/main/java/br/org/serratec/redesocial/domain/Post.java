package br.org.serratec.redesocial.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Preencha o conteúdo")
	@Column(nullable = false)
	private String conteudo;

	@Column
	@NotNull(message = "Preencha a data")
	private LocalDate dataCriacao;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	@NotNull(message = "Preencha o id do usuario")
	private Usuario usuario;

	@JsonManagedReference
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Comentario> comentarios;

	public Post() {
	}

	public Post(Long id, String conteudo, LocalDate dataCriacao, Usuario usuario, List<Comentario> comentarios) {
		this.id = id;
		this.conteudo = conteudo;
		this.dataCriacao = dataCriacao;
		this.usuario = usuario;
		this.comentarios = comentarios;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

}

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
@Table(name = "postagem")
public class Postagem {

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

<<<<<<< HEAD:redesocial/src/main/java/br/org/serratec/redesocial/domain/Post.java
	@JsonManagedReference
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Comentario> comentarios;

	public Post(Long id, String conteudo, LocalDate dataCriacao, Usuario usuario, List<Comentario> comentarios) {
=======
//	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "postagem", fetch = FetchType.EAGER)
	private List<Comentario> comentarios;

	public Postagem(Long id, String conteudo, LocalDate dataCriacao, Usuario usuario, List<Comentario> comentarios) {
>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b:redesocial/src/main/java/br/org/serratec/redesocial/domain/Postagem.java
		this.id = id;
		this.conteudo = conteudo;
		this.dataCriacao = dataCriacao;
		this.usuario = usuario;
		this.comentarios = comentarios;
	}

<<<<<<< HEAD:redesocial/src/main/java/br/org/serratec/redesocial/domain/Post.java
	public Post() {
=======
	public Postagem() {
>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b:redesocial/src/main/java/br/org/serratec/redesocial/domain/Postagem.java

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
		Postagem other = (Postagem) obj;
		return Objects.equals(id, other.id);
	}

}

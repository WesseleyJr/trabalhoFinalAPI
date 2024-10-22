package br.org.serratec.redesocial.dto;

import java.time.LocalDate;

import br.org.serratec.redesocial.domain.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String sobrenome;
	private Integer qntSeguidores = 0;
	private LocalDate dataNascimento;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.dataNascimento = usuario.getDataNascimento();
		this.qntSeguidores = usuario.getSeguidores().size();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Integer getQntSeguidores() {
		return qntSeguidores;
	}

	public void setQntSeguidores(Integer qntSeguidores) {
		this.qntSeguidores = qntSeguidores;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
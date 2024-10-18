package br.org.serratec.redesocial.dto;

import java.time.LocalDate;

public class UsuarioInserirDTO {

	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String email;
	private String senha;
	private String confirmaSenha;

	
	public UsuarioInserirDTO() {
		}


	public UsuarioInserirDTO(String nome, String sobrenome, LocalDate dataNascimento, String email, String senha,
			String confirmaSenha) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
		this.confirmaSenha = confirmaSenha;
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


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getConfirmaSenha() {
		return confirmaSenha;
	}


	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
}

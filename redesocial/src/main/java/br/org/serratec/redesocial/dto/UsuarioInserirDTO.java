package br.org.serratec.redesocial.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioInserirDTO {

	@NotBlank(message= "Preencha o nome")
	private String nome;
<<<<<<< HEAD
	
	@NotBlank(message= "Preencha o sobrenome")
	private String sobrenome;
	
	@NotNull(message= "Preencha a data")
	private LocalDate dataNascimento;
	
	@NotBlank(message= "Preencha o email")
	private String email;
	
	@NotBlank(message= "Preencha a senha")
	private String senha;
	
	@NotBlank(message= "Confirma a senha")
	private String confirmaSenha;
=======
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
>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b

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

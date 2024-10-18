package br.org.serratec.redesocial.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ComentarioDTO {
	
	private Long id;
	private String texto;
	private LocalDate dataComentario;
	
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
	@Override
	public int hashCode() {
		return Objects.hash(dataComentario, id, texto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComentarioDTO other = (ComentarioDTO) obj;
		return Objects.equals(dataComentario, other.dataComentario) && Objects.equals(id, other.id)
				&& Objects.equals(texto, other.texto);
	}

}

package br.org.serratec.redesocial.domain;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "relacionamento")
public class Seguidor {
	
	@Column (nullable = false)
	@NotBlank (message = "Prencha o campo")
	private LocalDate dataInicioSeguimento;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Seguidor() {

    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }
    
	public LocalDate getDataInicioSeguimento() {
		return dataInicioSeguimento;
	}

	public void setDataInicioSeguimento(LocalDate dataInicioSeguimento) {
		this.dataInicioSeguimento = dataInicioSeguimento;
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
		Seguidor other = (Seguidor) obj;
		return Objects.equals(id, other.id);
	}
    
}
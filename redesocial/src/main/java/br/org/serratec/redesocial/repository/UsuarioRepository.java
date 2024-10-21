package br.org.serratec.redesocial.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.org.serratec.redesocial.domain.Usuario;
import br.org.serratec.redesocial.dto.UsuarioDTO;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	// Busca de usuário por nome
	@Query("SELECT u FROM Usuario u WHERE UPPER (u.nome) LIKE UPPER(CONCAT('%', :paramNome, '%'))")
	Page<UsuarioDTO> buscarPorNome(String paramNome, Pageable pageable);

	// Busca de usuários por idade (com query nativa)
	@Query("SELECT u FROM Usuario u WHERE TIMESTAMPDIFF(YEAR, u.dataNascimento, CURRENT_DATE) BETWEEN :idadeMin AND :idadeMax")
	List<UsuarioDTO> findUsuariosByIdadeBetween(Integer idadeMin, Integer idadeMax);

	Usuario findByEmail(String email);

}

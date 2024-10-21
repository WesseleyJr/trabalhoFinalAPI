package br.org.serratec.redesocial.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.org.serratec.redesocial.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

//	// Busca de usuário por nome
//	@Query("SELECT u FROM Usuario u WHERE UPPER (u.nome) LIKE UPPER(CONCAT('%', :paramNome, '%'))")
//	Page<Usuario> buscarPorNome(String paramNome, Pageable pageable);
//
//	// Busca de usuário por data de nascimento
//	@Query("SELECT u FROM Usuario u WHERE u.dataNascimento BETWEEN :dataInicio AND :dataFim")
//	List<Usuario> buscarPorDataNascimentoEntre(LocalDate dataInicio, LocalDate dataFim);
//
//	// Busca de usuários por idade (com query nativa)
//	@Query(value = """
//			SELECT u.*, TIMESTAMPDIFF(YEAR, u.data_nascimento, CURDATE()) AS idade
//			FROM usuario u
//			HAVING idade = :idade
//			""",
//
//			nativeQuery = true)
//	List<Usuario> buscarPorIdade(Integer idade);

	Usuario findByEmail(String email);

}

package br.org.serratec.redesocial.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.org.serratec.redesocial.domain.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
	
	@Query("SELECT c FROM COMENTARIO c WHERE c.id_usuario = :id")
	Page<Comentario> BuscarPorUsuario(Long id, Pageable pageable);
	
	@Query("SELECT c FROM COMENTARIO c WHERE c.id_post = :id")
	Page<Comentario> BuscarPorPost(Long id, Pageable pageable);

}

package br.org.serratec.redesocial.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.org.serratec.redesocial.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
//	@Query("SELECT p FROM POST p WHERE p.id_usuario = :id")
//	Page<Post> BuscarPorUsuario(Long id, Pageable pageable);
	
}

package br.org.serratec.redesocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import br.org.serratec.redesocial.domain.Seguidor;
import br.org.serratec.redesocial.domain.Usuario;

@Repository
public interface SeguidorRepository extends JpaRepository<Seguidor, Long>{
	
	boolean existsByUsuarioSeguidorAndUsuarioSeguido (Usuario usuarioSeguidor, Usuario usuarioSeguido);
=======
import br.org.serratec.redesocial.domain.Relacionamento;

@Repository
public interface SeguidorRepository extends JpaRepository<Relacionamento, Long> {

>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b
}

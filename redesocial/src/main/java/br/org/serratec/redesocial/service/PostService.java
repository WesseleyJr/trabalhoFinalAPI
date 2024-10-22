package br.org.serratec.redesocial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.org.serratec.redesocial.domain.Post;
import br.org.serratec.redesocial.domain.Usuario;
import br.org.serratec.redesocial.dto.PostDTO;
import br.org.serratec.redesocial.dto.PostInserirDTO;
import br.org.serratec.redesocial.exception.NotFoundException;
import br.org.serratec.redesocial.repository.PostRepository;
import br.org.serratec.redesocial.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class PostService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PostRepository postRepository;

	public Page<PostDTO> findAll(Pageable pageable) {
		Page<Post> posts = postRepository.findAll(pageable);
		List<PostDTO> postsDTO = posts.stream().map(PostDTO::new).toList();
		return new PageImpl<>(postsDTO, pageable, posts.getTotalElements());
	}

	public PostDTO buscar(Long id) {
		Optional<Post> postOpt = postRepository.findById(id);
		if (!postOpt.isPresent()) {
			throw new NotFoundException("Postagem não encontrada, ID: " + id);
		}
		return new PostDTO(postOpt.get());
	}

	@Transactional
	public PostInserirDTO inserir(PostInserirDTO postInserirDTO) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(postInserirDTO.getIdUsuario());

		if (!usuarioOpt.isPresent()) {
			throw new NotFoundException("Usuario não encontrado, ID: " + postInserirDTO.getIdUsuario());
		}
		Post post = new Post();
		post.setConteudo(postInserirDTO.getConteudo());
		post.setDataCriacao(postInserirDTO.getDataCriacao());
		post.setUsuario(usuarioOpt.get());

		post = postRepository.save(post);
		return new PostInserirDTO(post);
	}

	@Transactional
	public PostInserirDTO att(PostInserirDTO postInserirDTO, Long id) {
		Optional<Post> postOpt = postRepository.findById(id);
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(postInserirDTO.getIdUsuario());

		if (!postOpt.isPresent()) {
			throw new NotFoundException("Postagem não encontrada, ID: " + id);
		}
		if (!usuarioOpt.isPresent()) {
			throw new NotFoundException("Usuario não encontrado, ID: " + postInserirDTO.getIdUsuario());
		}

		Post post = postOpt.get();
		post.setConteudo(postInserirDTO.getConteudo());
		post.setDataCriacao(postInserirDTO.getDataCriacao());
		post.setUsuario(usuarioOpt.get());

		post = postRepository.save(post);
		return new PostInserirDTO(post);
	}

	@Transactional
	public void del(Long id) {
		if (!postRepository.existsById(id)) {
			throw new NotFoundException("Postagem não encontrada, ID: " + id);
		}
		postRepository.deleteById(id);
	}

}

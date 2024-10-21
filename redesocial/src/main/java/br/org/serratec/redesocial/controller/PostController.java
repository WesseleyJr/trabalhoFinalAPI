package br.org.serratec.redesocial.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.redesocial.domain.Post;
import br.org.serratec.redesocial.dto.PostDTO;
import br.org.serratec.redesocial.dto.PostInserirDTO;
import br.org.serratec.redesocial.service.PostService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping
	public ResponseEntity<Page<PostDTO>> listar(
			@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 3) Pageable pageable) {
		Page<PostDTO> post = postService.findAll(pageable);
		return ResponseEntity.ok(post);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostDTO> buscar(@PathVariable Long id) {
		PostDTO postDTO = postService.buscar(id);
		return ResponseEntity.ok(postDTO);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PostInserirDTO> adicionar(@Valid @RequestBody PostInserirDTO postagemInserirDTO) {
		PostInserirDTO postDTO = postService.inserir(postagemInserirDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(postDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(postDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PostInserirDTO> alterar(@PathVariable Long id,
			@Valid @RequestBody PostInserirDTO postagemInserirDTO) {
		PostInserirDTO p = postService.att(postagemInserirDTO, id);
		return ResponseEntity.ok(p);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Post> deletar(@PathVariable Long id) {
		postService.del(id);
		return ResponseEntity.ok().build();
	}

}

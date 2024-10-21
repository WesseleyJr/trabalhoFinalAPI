package br.org.serratec.redesocial.controller;

<<<<<<< HEAD
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
=======
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.redesocial.domain.Comentario;
import br.org.serratec.redesocial.dto.ComentarioDTO;
import br.org.serratec.redesocial.dto.ComentarioInserirDTO;
import br.org.serratec.redesocial.service.ComentarioService;
=======
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.redesocial.domain.Comentario;
import br.org.serratec.redesocial.dto.ComentarioDTO;
import br.org.serratec.redesocial.repository.ComentarioRepository;
>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b
import jakarta.validation.Valid;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

	@Autowired
<<<<<<< HEAD
	private ComentarioService comentarioService;

	@GetMapping
	public ResponseEntity<Page<ComentarioDTO>> listar(
			@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable pageable) {
		Page<ComentarioDTO> comentario = comentarioService.findAll(pageable);
		return ResponseEntity.ok(comentario);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ComentarioDTO> buscar(@PathVariable Long id) {
		ComentarioDTO comentarioDTO = comentarioService.buscar(id);
		return ResponseEntity.ok(comentarioDTO);
	}

	@PostMapping
	public ResponseEntity<ComentarioDTO> adicionar(@Valid @RequestBody ComentarioInserirDTO comentarioInserirDTO) {
		ComentarioDTO comentarioDTO = comentarioService.inserir(comentarioInserirDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comentarioDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(comentarioDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ComentarioDTO> alterar(@PathVariable Long id,
			@Valid @RequestBody ComentarioInserirDTO comentarioInserirDTO) {

		ComentarioDTO comentarioDTO = comentarioService.att(comentarioInserirDTO, id);
		return ResponseEntity.ok(comentarioDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Comentario> deletar(@PathVariable Long id) {
		comentarioService.del(id);
=======
	private ComentarioRepository comentarioRepository;
	
	@GetMapping
	public ResponseEntity<List<ComentarioDTO>> listar() {
		List<Comentario> comentarios = comentarioRepository.findAll();
		List<ComentarioDTO> comentariosDto = comentarios.stream().map(ComentarioDTO :: new).collect(Collectors.toList());
		return ResponseEntity.ok(comentariosDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Comentario> buscar(@PathVariable Long id) {
		Optional<Comentario> comentarioOpt = comentarioRepository.findById(id);
		if (comentarioOpt.isPresent()) {
			return ResponseEntity.ok(comentarioOpt.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Comentario> adicionar(@Valid @RequestBody Comentario comentario) {
		return ResponseEntity.ok(comentarioRepository.save(comentario));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Comentario> alterar(@PathVariable Long id, @Valid @RequestBody Comentario comentario) {
		if (!comentarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		comentario.setId(id);
		comentario = comentarioRepository.save(comentario);
		return ResponseEntity.ok(comentario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Comentario> deletar(@PathVariable Long id) {
		if (!comentarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		comentarioRepository.deleteById(id);
>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b
		return ResponseEntity.ok().build();
	}
}

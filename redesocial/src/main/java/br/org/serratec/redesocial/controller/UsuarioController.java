package br.org.serratec.redesocial.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.redesocial.domain.Usuario;
import br.org.serratec.redesocial.dto.UsuarioDTO;
<<<<<<< HEAD
import br.org.serratec.redesocial.dto.UsuarioInserirDTO;
=======
import br.org.serratec.redesocial.repository.UsuarioRepository;
>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b
import br.org.serratec.redesocial.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
<<<<<<< HEAD
	public ResponseEntity<Page<UsuarioDTO>> listar(@PageableDefault(sort="id", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable pageable) {
		Page<UsuarioDTO> usuarios = usuarioService.findAll(pageable);
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> buscar(@PathVariable Long id) {
		UsuarioDTO usuarioDTO = usuarioService.buscar(id);
		return ResponseEntity.ok(usuarioDTO);
=======
	public ResponseEntity<List<UsuarioDTO>> listar() {
		return ResponseEntity.ok(usuarioService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
		Optional<Usuario> usuarioOpt = usuarioService.buscar(id);
		if (usuarioOpt.isPresent()) {
			return ResponseEntity.ok(usuarioOpt.get());
		}
		return ResponseEntity.notFound().build();
>>>>>>> 05daefa5641ec9cae839e81988b220c8d0bba05b
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> adicionar(@Valid @RequestBody UsuarioInserirDTO usuarioInserirDTO) {
		UsuarioDTO usuarioDTO = usuarioService.inserir(usuarioInserirDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(usuarioDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UsuarioInserirDTO> atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioInserirDTO usuarioInserirDTO) {
		UsuarioInserirDTO usuarioInserir = usuarioService.att(usuarioInserirDTO, id);
		return ResponseEntity.ok(usuarioInserir);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> deletar(@PathVariable Long id) {
		usuarioService.del(id);
		return ResponseEntity.ok().build();
	}

}

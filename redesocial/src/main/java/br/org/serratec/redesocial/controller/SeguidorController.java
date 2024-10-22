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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.redesocial.dto.SeguidoUsuarioDTO;
import br.org.serratec.redesocial.dto.SeguidorDTO;
import br.org.serratec.redesocial.service.SeguidorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/seguidores")
public class SeguidorController {

	@Autowired
	private SeguidorService seguidorService;

	@GetMapping
	public ResponseEntity<Page<SeguidorDTO>> listar(
			@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable pageable) {
		Page<SeguidorDTO> seguidor = seguidorService.findAll(pageable);
		return ResponseEntity.ok(seguidor);
	}

	@GetMapping("/{idUsuario}")
	public ResponseEntity<SeguidoUsuarioDTO> buscarSeguidoresPorUsuario(@PathVariable Long idUsuario) {
		SeguidoUsuarioDTO seguidoUsuarioDTO = seguidorService.seguidoresPorUsuario(idUsuario);
		return ResponseEntity.ok(seguidoUsuarioDTO);
	}

	@PostMapping
	public ResponseEntity<SeguidorDTO> seguir(@Valid @RequestBody SeguidorDTO seguidorDTO) {
		SeguidorDTO seguidor = seguidorService.seguir(seguidorDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(seguidor.getId())
				.toUri();
		return ResponseEntity.created(uri).body(seguidor);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<SeguidorDTO> deletar(@PathVariable Long id) {
		seguidorService.del(id);
		return ResponseEntity.ok().build();
	}
}

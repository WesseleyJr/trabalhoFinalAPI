package br.org.serratec.redesocial.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.org.serratec.redesocial.domain.Seguidor;
import br.org.serratec.redesocial.domain.Usuario;
import br.org.serratec.redesocial.dto.SeguidoUsuarioDTO;
import br.org.serratec.redesocial.dto.SeguidorDTO;
import br.org.serratec.redesocial.dto.SeguidorUsuarioDTO;
import br.org.serratec.redesocial.exception.FollowException;
import br.org.serratec.redesocial.exception.NotFoundException;
import br.org.serratec.redesocial.repository.SeguidorRepository;
import br.org.serratec.redesocial.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class SeguidorService {

	@Autowired
	private SeguidorRepository seguidorRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Page<SeguidorDTO> findAll(Pageable pageable) {
		Page<Seguidor> seguidores = seguidorRepository.findAll(pageable);
		List<SeguidorDTO> seguidoresDTO = seguidores.stream().map(SeguidorDTO::new).collect(Collectors.toList());
		return new PageImpl<>(seguidoresDTO, pageable, seguidores.getTotalElements());
	}

	@Transactional
	public SeguidorDTO seguir(SeguidorDTO seguidorDTO) {
		Optional<Usuario> seguidoOpt = usuarioRepository.findById(seguidorDTO.getIdUsuarioSeguido());
		Optional<Usuario> seguidorOpt = usuarioRepository.findById(seguidorDTO.getIdUsuarioSeguidor());

		if (!seguidoOpt.isPresent()) {
			throw new NotFoundException("Usuário seguido não encontrado, ID: " + seguidorDTO.getIdUsuarioSeguido());
		}
		if (!seguidorOpt.isPresent()) {
			throw new NotFoundException("Usuário seguidor não encontrado, ID: " + seguidorDTO.getIdUsuarioSeguidor());
		}

		Usuario seguido = seguidoOpt.get();
		Usuario seguidor = seguidorOpt.get();

		if (seguidorRepository.existsByUsuarioSeguidorAndUsuarioSeguido(seguidor, seguido)) {
			throw new FollowException("Você já segue essa pessoa");
		}
		if (seguidor.getId().equals(seguido.getId())) {
			throw new FollowException("Você não pode seguir a si mesmmo");
		}

		Seguidor seg = new Seguidor();
		seg.setDataInicioSeguimento(seguidorDTO.getDataInicioSeguimento());
		seg.setUsuarioSeguido(seguido);
		seg.setUsuarioSeguidor(seguidor);
		seg = seguidorRepository.save(seg);

		Usuario usuario = seguidoOpt.get();
		usuario.getSeguidores().add(seg);

		return new SeguidorDTO(seg);
	}

	@Transactional
	public void del(Long id) {
		if (!seguidorRepository.existsById(id)) {
			throw new NotFoundException("Relacionamento não encontrado, ID: " + id);
		}
		seguidorRepository.deleteById(id);
	}

	public SeguidoUsuarioDTO seguidoresPorUsuario(Long id) {
		Optional<Usuario> seguidoOpt = usuarioRepository.findById(id);

		if (!seguidoOpt.isPresent()) {
			throw new NotFoundException("Usuário seguido não encontrado, ID: " + id);
		}

		Usuario usuario = seguidoOpt.get();

		SeguidoUsuarioDTO seguido = new SeguidoUsuarioDTO();
		seguido.setIdUsuarioSeguido(usuario.getId());
		seguido.setNomeUsuarioSeguido(usuario.getNome());
		seguido.setSobrenomeUsuarioSeguido(usuario.getSobrenome());
		List<SeguidorUsuarioDTO> seguidoresDTO = new ArrayList<>();

		for (Seguidor seguidor : usuario.getSeguidores()) {
			SeguidorUsuarioDTO seguidorDTO = new SeguidorUsuarioDTO(seguidor);
			seguidoresDTO.add(seguidorDTO);
		}

		seguido.setSeguidores(seguidoresDTO);
		return seguido;
	}
}

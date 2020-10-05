package br.com.bruno.osapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.bruno.osapi.controller.dto.ComentariosDto;
import br.com.bruno.osapi.controller.dto.ComentariosOrdemServicoDto;
import br.com.bruno.osapi.controller.dto.DetalhesOrdemServicoDto;
import br.com.bruno.osapi.controller.form.ComentarioForm;
import br.com.bruno.osapi.modelo.Comentarios;
import br.com.bruno.osapi.modelo.OrdemServico;
import br.com.bruno.osapi.repository.ComentariosRepository;
import br.com.bruno.osapi.repository.ExecutorOSRepository;
import br.com.bruno.osapi.repository.OrdemServicoRepository;

@RestController
@RequestMapping("/comentarios")
public class ComentariosController {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ExecutorOSRepository executorOSRepository;

	@Autowired
	private ComentariosRepository comentariosRepository;

	@GetMapping
	public List<ComentariosOrdemServicoDto> lista() {
		List<OrdemServico> ordensDeServico = ordemServicoRepository.findAll();
		return ComentariosOrdemServicoDto.converter(ordensDeServico);
	}

	@GetMapping("/{comentarioId}")
	public ResponseEntity<ComentariosDto> listarComentariosPorComentario(@PathVariable Long comentarioId) {
		Optional<Comentarios> comentario = comentariosRepository.findById(comentarioId);
		if (comentario.isPresent()) {
			return ResponseEntity.ok(new ComentariosDto(comentario.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/ordemservicos/{ordemServicoId}")
	public ResponseEntity<DetalhesOrdemServicoDto> listarComentariosPorOrdemServico(@PathVariable Long ordemServicoId) {
		Optional<OrdemServico> ordensDeServico = ordemServicoRepository.findById(ordemServicoId);
		if (ordensDeServico.isPresent()) {
			return ResponseEntity.ok(new DetalhesOrdemServicoDto(ordensDeServico.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/{ordemServicoId}")
	@Transactional
	public ResponseEntity<ComentariosDto> cadastrarComentario(@PathVariable Long ordemServicoId, @RequestBody @Valid ComentarioForm form,
			UriComponentsBuilder uriBuilder) {
		OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntityNotFoundException("Ordem de serviço não encontrada."));

		Comentarios comentario = form.converter(ordemServico, executorOSRepository, comentariosRepository);
		ordemServico.adicionarComentario(comentario);

		URI uri = uriBuilder.path("/comentarios/{id}/comentario/{idComentario}").buildAndExpand(ordemServico.getId(), comentario.getId()).toUri();
		return ResponseEntity.created(uri).body(new ComentariosDto(comentario));
	}

}

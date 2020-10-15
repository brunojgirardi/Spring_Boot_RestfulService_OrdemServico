package br.com.bruno.osapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.bruno.osapi.controller.dto.OrdemServicoDto;
import br.com.bruno.osapi.controller.dto.OrdemServicoFiltroDto;
import br.com.bruno.osapi.controller.form.AtualizacaoOrdemServicoForm;
import br.com.bruno.osapi.controller.form.OrdemServicoForm;
import br.com.bruno.osapi.modelo.OrdemServico;
import br.com.bruno.osapi.repository.ClienteRepository;
import br.com.bruno.osapi.repository.OrdemServicoRepository;

@RestController
@RequestMapping("/ordemservicos")
public class OrdemsDeServicoController {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<OrdemServicoDto> listar() {	
		List<OrdemServico> ordensDeServico = ordemServicoRepository.findAll();		
		return OrdemServicoDto.converter(ordensDeServico);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrdemServicoDto> listarPorOrdemServico(@PathVariable Long id) {
		Optional<OrdemServico> ordensDeServico = ordemServicoRepository.findById(id);
		if (ordensDeServico.isPresent()) {
			return ResponseEntity.ok(new OrdemServicoDto(ordensDeServico.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@RequestMapping("/filtro")
	@GetMapping
	public List<OrdemServicoFiltroDto> listaFiltroPorExecutor(String nomeExecutor) {
		if (nomeExecutor == null) {
			List<OrdemServico> ordensDeServico = ordemServicoRepository.findAll();
			return OrdemServicoFiltroDto.converter(ordensDeServico);
		} else {
			List<OrdemServico> ordensDeServico = ordemServicoRepository.carregarPorOrdemServicoNome(nomeExecutor);
			return OrdemServicoFiltroDto.converter(ordensDeServico);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<OrdemServicoDto> cadastrar(@RequestBody @Valid OrdemServicoForm osForm, UriComponentsBuilder uriBuilder) {
		OrdemServico ordemServico = osForm.converter(clienteRepository);
		ordemServicoRepository.save(ordemServico);

		URI uri = uriBuilder.path("/ordemservicos/{id}").buildAndExpand(ordemServico.getId()).toUri();
		return ResponseEntity.created(uri).body(new OrdemServicoDto(ordemServico));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<OrdemServicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoOrdemServicoForm osFormPut) {
		Optional<OrdemServico> optional = ordemServicoRepository.findById(id);
		if (optional.isPresent()) {
			OrdemServico ordemServico = osFormPut.atualizar(id, ordemServicoRepository);
			return ResponseEntity.ok(new OrdemServicoDto(ordemServico));
		}		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<OrdemServico> optional = ordemServicoRepository.findById(id);
		if (optional.isPresent()) {
			ordemServicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}

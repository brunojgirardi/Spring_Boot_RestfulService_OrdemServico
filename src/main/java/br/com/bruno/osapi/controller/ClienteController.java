package br.com.bruno.osapi.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.bruno.osapi.config.exception.DomainException;
import br.com.bruno.osapi.controller.dto.ClienteDto;
import br.com.bruno.osapi.controller.form.ClienteForm;
import br.com.bruno.osapi.modelo.Cliente;
import br.com.bruno.osapi.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<ClienteDto> lista() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ClienteDto.converter(clientes);
	}

	@GetMapping("/filtro")
	public List<Cliente> listaFiltro(String nomeCliente) {
		if (nomeCliente == null) {
			List<Cliente> clientes = clienteRepository.findAll();
			return clientes;
		} else {
			List<Cliente> clientes = clienteRepository.findByNome(nomeCliente);
			return clientes;
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm osForm, UriComponentsBuilder uriBuilder) {
		Cliente cliente = osForm.converter(clienteRepository);
		if (clienteRepository.findByEmail(cliente.getEmail()) != null) {
			throw new DomainException("Já existe cliente registrado com esse e-mail. Tente inserir outro.");
		}

		clienteRepository.save(cliente);
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}

}
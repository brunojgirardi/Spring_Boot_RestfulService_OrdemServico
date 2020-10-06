package br.com.bruno.osapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.osapi.modelo.ExecutorOrdemServico;
import br.com.bruno.osapi.repository.ExecutorOSRepository;

@RestController
@RequestMapping("/executor")
public class ExecutorOSController {

	@Autowired
	private ExecutorOSRepository executorOSRepository;

	@GetMapping
	public List<ExecutorOrdemServico> lista() {
		List<ExecutorOrdemServico> executoresOs = executorOSRepository.findAll();
		return executoresOs;
	}

	@GetMapping("/filtro")
	public List<ExecutorOrdemServico> listaFiltro(String nomeExecutorOs) {
		List<ExecutorOrdemServico> executoresOsList = executorOSRepository.findByNome(nomeExecutorOs);		
		return executoresOsList;
	}

}

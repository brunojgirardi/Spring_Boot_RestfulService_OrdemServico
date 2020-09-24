package br.com.bruno.osapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.osapi.modelo.ExecutorOrdemServico;
import br.com.bruno.osapi.repository.ExecutorOSRepository;

@RestController
public class ExecutorOSController {

	@Autowired
	private ExecutorOSRepository executorOSRepository;
	
	@RequestMapping("/executor")
	@ResponseBody
	public List<ExecutorOrdemServico> listaTeste() {
		List<ExecutorOrdemServico> executoresOs = executorOSRepository.findAll();

		return executoresOs;
	}
	
	@RequestMapping("/executor/filtro")
	@ResponseBody
	public List<ExecutorOrdemServico> listaFiltro(String nomeExcecutorOs) {			
		if (nomeExcecutorOs == null) {
			List<ExecutorOrdemServico> executoresOs = executorOSRepository.findAll();
			return executoresOs;
		} else {
			List<ExecutorOrdemServico> executoresOs = executorOSRepository.findByNome(nomeExcecutorOs);
			return executoresOs;
		}
	}
	
}

package br.com.bruno.osapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.osapi.controller.dto.DetalhesOrdemServicoDto;
import br.com.bruno.osapi.modelo.OrdemServico;
import br.com.bruno.osapi.repository.OrdemServicoRepository;

@RestController
@RequestMapping("/comentarios")
public class ComentariosController {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@RequestMapping("/general")	
	public List<OrdemServico> lista() {
		List<OrdemServico> ordensDeServico = ordemServicoRepository.findAll();
		return ordensDeServico;
	}
	
	@GetMapping("{id}")
	public DetalhesOrdemServicoDto detalharDados(@PathVariable("id") Long codigoId) {
		OrdemServico ordemServico = ordemServicoRepository.getOne(codigoId);
		return new DetalhesOrdemServicoDto(ordemServico);
	}
	
}

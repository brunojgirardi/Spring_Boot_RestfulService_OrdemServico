package br.com.bruno.osapi.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bruno.osapi.modelo.OrdemServico;
import br.com.bruno.osapi.modelo.StatusOrdemServico;

public class OrdemServicoFiltroDto {

	private Long id;
	private String marca;
	private String modelo;
	private String equipamento;
	private String descricao;
	private String nomeExecutor;
	private StatusOrdemServico status;
	private LocalDateTime dataCriacao = LocalDateTime.now();

	public OrdemServicoFiltroDto(OrdemServico ordemServico) {
		this.id = ordemServico.getId();
		this.marca = ordemServico.getMarca();
		this.modelo = ordemServico.getModelo();
		this.equipamento = ordemServico.getEquipamento();
		this.descricao = ordemServico.getDescricao();	
		
		if (ordemServico.getExecutorOs() == null) {
			this.nomeExecutor = "Sem executor";
		} else {
			this.nomeExecutor = ordemServico.getExecutorOs().getNome();
		}
		
		this.status = ordemServico.getStatus();
		this.dataCriacao = ordemServico.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public StatusOrdemServico getStatus() {
		return status;
	}

	public String getNomeExecutor() {
		return nomeExecutor;
	}

	public static List<OrdemServicoFiltroDto> converter(List<OrdemServico> ordemServicos) {
		return ordemServicos.stream().map(OrdemServicoFiltroDto::new).collect(Collectors.toList());
	}
}

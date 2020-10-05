package br.com.bruno.osapi.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bruno.osapi.modelo.OrdemServico;

public class OrdemServicoDto {

	private Long id;
	private String marca;
	private String modelo;
	private String equipamento;
	private String descricao;
	private String nomeExecutor;
	private LocalDateTime dataCriacao = LocalDateTime.now();

	public OrdemServicoDto(OrdemServico ordemServico) {
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

	public String getNomeExecutor() {
		return nomeExecutor;
	}

	public static List<OrdemServicoDto> converter(List<OrdemServico> ordemServicos) {
		return ordemServicos.stream().map(OrdemServicoDto::new).collect(Collectors.toList());
	}

}

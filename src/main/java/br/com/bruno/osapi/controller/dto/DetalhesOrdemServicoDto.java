package br.com.bruno.osapi.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.bruno.osapi.modelo.OrdemServico;
import br.com.bruno.osapi.modelo.StatusOrdemServico;

public class DetalhesOrdemServicoDto {

	private Long id;
	private String marca;
	private String modelo;
	private String equipamento;
	private LocalDateTime dataCriacao;
	private String nomeExecutor;
	private String descricao;
	private StatusOrdemServico status;
	private List<ComentariosDto> comentarios;

	public DetalhesOrdemServicoDto(OrdemServico ordemServico) {
		this.id = ordemServico.getId();
		this.marca = ordemServico.getMarca();
		this.modelo = ordemServico.getModelo();
		this.equipamento = ordemServico.getEquipamento();
		this.dataCriacao = ordemServico.getDataCriacao();
		this.nomeExecutor = ordemServico.getExecutorOs().getNome();
		this.descricao = ordemServico.getDescricao();
		this.status = ordemServico.getStatus();
		this.comentarios = new ArrayList<>();
		this.comentarios.addAll(ordemServico.getComentarios().stream().map(ComentariosDto::new).collect(Collectors.toList()));
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

	public String getNomeExecutor() {
		return nomeExecutor;
	}

	public String getDescricao() {
		return descricao;
	}

	public StatusOrdemServico getStatus() {
		return status;
	}

	public List<ComentariosDto> getComentarios() {
		return comentarios;
	}

}

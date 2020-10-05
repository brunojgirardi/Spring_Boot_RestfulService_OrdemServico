package br.com.bruno.osapi.controller.dto;

import java.time.LocalDateTime;

import br.com.bruno.osapi.modelo.Comentarios;

public class ComentariosDto {

	private Long id;
	private Long idOs;
	private String mensagem;
	private LocalDateTime dataPublicacao;
	private String nomeExecutor;

	public ComentariosDto(Comentarios comentarios) {
		this.id = comentarios.getId();
		this.mensagem = comentarios.getMensagem();
		this.dataPublicacao = comentarios.getDataPublicacao();
		this.nomeExecutor = comentarios.getExecutorOs().getNome();
		this.idOs = comentarios.getOrdemServico().getId();
	}

	public Long getId() {
		return id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataPublicacao() {
		return dataPublicacao;
	}

	public String getNomeExecutor() {
		return nomeExecutor;
	}

	public Long getIdOs() {
		return idOs;
	}

}
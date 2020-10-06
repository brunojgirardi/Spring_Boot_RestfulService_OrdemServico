package br.com.bruno.osapi.controller.dto;

import java.time.LocalDateTime;

import br.com.bruno.osapi.modelo.Comentarios;

public class ComentariosDto {

	private Long idComentario;
	private Long idOrdemServico;
	private String mensagem;
	private LocalDateTime dataPublicacao;
	private String nomeExecutor;

	public ComentariosDto(Comentarios comentarios) {
		this.idComentario = comentarios.getId();
		this.mensagem = comentarios.getMensagem();
		this.dataPublicacao = comentarios.getDataPublicacao();
		this.nomeExecutor = comentarios.getExecutorOs().getNome();
		this.idOrdemServico = comentarios.getOrdemServico().getId();
	}

	public Long getIdComentario() {
		return idComentario;
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

	public Long getIdOrdemServico() {
		return idOrdemServico;
	}

}

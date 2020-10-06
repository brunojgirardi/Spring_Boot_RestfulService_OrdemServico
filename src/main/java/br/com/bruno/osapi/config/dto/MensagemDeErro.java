package br.com.bruno.osapi.config.dto;

import java.util.Date;

public class MensagemDeErro {

	private Date dataOcorrencia;
	private String mensagem;

	public MensagemDeErro() {}

	public MensagemDeErro(Date dataOcorrencia, String mensagem) {
		this.dataOcorrencia = dataOcorrencia;
		this.mensagem = mensagem;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}

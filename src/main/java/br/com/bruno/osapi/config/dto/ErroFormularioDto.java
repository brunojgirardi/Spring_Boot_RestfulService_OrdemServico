package br.com.bruno.osapi.config.dto;

public class ErroFormularioDto {

	private String campo;
	private String mensagemErro;	

	public ErroFormularioDto(String campo, String mensagemErro) {
		super();
		this.campo = campo;
		this.mensagemErro = mensagemErro;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

}

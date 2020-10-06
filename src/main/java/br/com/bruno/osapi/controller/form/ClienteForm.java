package br.com.bruno.osapi.controller.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.bruno.osapi.modelo.Cliente;
import br.com.bruno.osapi.repository.ClienteRepository;

public class ClienteForm {

	@Size(max = 60)
	@NotNull
	private String nome;

	@Size(max = 255)
	private String endereco;

	@Size(max = 255)
	@NotNull
	private String email;

	@Size(max = 20)
	@NotNull
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cliente converter(ClienteRepository repository) {	
		return new Cliente(nome, endereco, email, telefone);
	}

}

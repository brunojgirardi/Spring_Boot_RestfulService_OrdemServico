package br.com.bruno.osapi.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.bruno.osapi.modelo.Cliente;
import br.com.bruno.osapi.modelo.OrdemServico;

public class ClienteDto {

	private String nome;
	private String endereco;
	private String email;
	private String telefone;

	public ClienteDto(Cliente cliente) {
		this.nome = cliente.getNome();
		this.endereco = cliente.getEndereco();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}

}

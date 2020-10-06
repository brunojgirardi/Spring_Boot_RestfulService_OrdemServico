<<<<<<< HEAD
package br.com.bruno.osapi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.bruno.osapi.modelo.Cliente;
import br.com.bruno.osapi.modelo.OrdemServico;
import br.com.bruno.osapi.repository.ClienteRepository;

public class OrdemServicoForm {

	@NotNull
	@NotEmpty
	private String marca;
	@NotNull
	@NotEmpty
	private String modelo;
	@NotNull
	@NotEmpty
	private String equipamento;
	@NotNull
	@Length(min = 10)
	private String descricao;
	@NotNull
	@NotEmpty
	private String emailCliente;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public OrdemServico converter(ClienteRepository repository) {	
		Cliente cliente = repository.findByEmail(emailCliente);
		return new OrdemServico(marca, modelo, descricao, equipamento, cliente);
	}

}
=======
package br.com.bruno.osapi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.bruno.osapi.modelo.Cliente;
import br.com.bruno.osapi.modelo.OrdemServico;
import br.com.bruno.osapi.repository.ClienteRepository;

public class OrdemServicoForm {

	@NotNull
	@NotEmpty
	private String marca;
	@NotNull
	@NotEmpty
	private String modelo;
	@NotNull
	@NotEmpty
	private String equipamento;
	@NotNull
	@Length(min = 10)
	private String descricao;
	@NotNull
	@NotEmpty
	private String emailCliente;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public OrdemServico converter(ClienteRepository repository) {	
		Cliente cliente = repository.findByEmail(emailCliente);
		return new OrdemServico(marca, modelo, descricao, equipamento, cliente);
	}

}
>>>>>>> 582d4c0d73dd8a2a3149de2ef90ed4dcb92d373c

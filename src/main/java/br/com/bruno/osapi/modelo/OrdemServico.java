package br.com.bruno.osapi.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String marca;
	@NotNull
	private String modelo;
	@NotNull
	private String equipamento;
	@NotNull
	private String descricao;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private LocalDateTime dataFechamento;
	@Enumerated(EnumType.STRING)
	private StatusOrdemServico status = StatusOrdemServico.ABERTA;
	@NotNull
	@ManyToOne
	private Cliente cliente; 
	@OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL)
	private List<Comentarios> comentarios = new ArrayList<>(); 
	@ManyToOne
	private ExecutorOrdemServico executorOrdemServico; 

	public OrdemServico() {	
	}

	public OrdemServico(String marca, String modelo, String equipamento, String descricao, Cliente cliente) {
		this.marca = marca;
		this.modelo = modelo;
		this.equipamento = equipamento;
		this.descricao = descricao;
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public StatusOrdemServico getStatus() {
		return status;
	}

	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}
	
	public void adicionarComentario(Comentarios comentario) {
        this.comentarios.add(comentario);
        comentario.setOrdemServico(this);   
    }

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public ExecutorOrdemServico getExecutorOs() {
		return executorOrdemServico;
	}

	public void setExecutorOs(ExecutorOrdemServico executorOs) {
		this.executorOrdemServico = executorOs;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

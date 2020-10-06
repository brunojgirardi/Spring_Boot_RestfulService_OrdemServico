package br.com.bruno.osapi.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Comentarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 255)
	@NotNull
	private String mensagem;

	private LocalDateTime dataPublicacao = LocalDateTime.now();

	private LocalDateTime dataEdicao;

	@ManyToOne
	private OrdemServico ordemServico;

	@ManyToOne
	private ExecutorOrdemServico executorOs;

	private Boolean solucionado = false;

	public Comentarios() {
		super();
	}

	public Comentarios(String mensagem, OrdemServico ordemServico, ExecutorOrdemServico executorOs, Boolean solucionado) {
		this.mensagem = mensagem;
		this.ordemServico = ordemServico;
		this.executorOs = executorOs;
		this.solucionado = solucionado;
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
		Comentarios other = (Comentarios) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public LocalDateTime getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDateTime dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public ExecutorOrdemServico getExecutorOs() {
		return executorOs;
	}

	public void setExecutorOs(ExecutorOrdemServico executorOs) {
		this.executorOs = executorOs;
	}

	public Boolean getSolucionado() {
		return solucionado;
	}

	public void setSolucionado(Boolean solucionado) {
		this.solucionado = solucionado;
	}

	public LocalDateTime getDataEdicao() {
		return dataEdicao;
	}

	public void setDataEdicao(LocalDateTime dataEdicao) {
		this.dataEdicao = dataEdicao;
	}

}

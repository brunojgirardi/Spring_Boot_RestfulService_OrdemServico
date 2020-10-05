package br.com.bruno.osapi.controller.form;

import javax.validation.constraints.NotNull;

import br.com.bruno.osapi.modelo.OrdemServico;
import br.com.bruno.osapi.modelo.StatusOrdemServico;
import br.com.bruno.osapi.repository.OrdemServicoRepository;

public class AtualizacaoOrdemServicoForm {

	@NotNull	
	private StatusOrdemServico status;

	public StatusOrdemServico getStatus() {
		return status;
	}

	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}
	
	public OrdemServico atualizar(Long id, OrdemServicoRepository ordemServicoRepository) {
		OrdemServico ordemServico = ordemServicoRepository.getOne(id);
		ordemServico.setStatus(this.status);
		return ordemServico;
	}

}

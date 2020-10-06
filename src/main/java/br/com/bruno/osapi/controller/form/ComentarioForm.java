<<<<<<< HEAD
package br.com.bruno.osapi.controller.form;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.bruno.osapi.modelo.Comentarios;
import br.com.bruno.osapi.modelo.ExecutorOrdemServico;
import br.com.bruno.osapi.modelo.OrdemServico;
import br.com.bruno.osapi.repository.ComentariosRepository;
import br.com.bruno.osapi.repository.ExecutorOSRepository;

public class ComentarioForm {

	@Size(max = 255)
	@NotNull
	private String descricaoComentario;
	
	@NotNull
	private Long executorComentario;

	public String getDescricaoComentario() {
		return descricaoComentario;
	}

	public void setDescricaoComentario(String descricaoComentario) {
		this.descricaoComentario = descricaoComentario;
	}

	public Long getExecutorComentario() {
		return executorComentario;
	}

	public void setExecutorComentario(Long executorComentario) {
		this.executorComentario = executorComentario;
	}

	public Comentarios converter(OrdemServico ordemServico, ExecutorOSRepository executorOsRep,
			ComentariosRepository comentariosRepository) {
		ExecutorOrdemServico executorOs = executorOsRep.findById(this.executorComentario)
				.orElseThrow(() -> new EntityNotFoundException("Executor não encontrado."));
		
		Comentarios novoComentario = new Comentarios();
		novoComentario.setOrdemServico(ordemServico);
		novoComentario.setExecutorOs(executorOs);
		novoComentario.setMensagem(this.descricaoComentario);
		return comentariosRepository.save(novoComentario);

	}

}
=======
package br.com.bruno.osapi.controller.form;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.bruno.osapi.modelo.Comentarios;
import br.com.bruno.osapi.modelo.ExecutorOrdemServico;
import br.com.bruno.osapi.modelo.OrdemServico;
import br.com.bruno.osapi.repository.ComentariosRepository;
import br.com.bruno.osapi.repository.ExecutorOSRepository;

public class ComentarioForm {

	@Size(max = 255)
	@NotNull
	private String descricaoComentario;
	
	@NotNull
	private Long executorComentario;

	public String getDescricaoComentario() {
		return descricaoComentario;
	}

	public void setDescricaoComentario(String descricaoComentario) {
		this.descricaoComentario = descricaoComentario;
	}

	public Long getExecutorComentario() {
		return executorComentario;
	}

	public void setExecutorComentario(Long executorComentario) {
		this.executorComentario = executorComentario;
	}

	public Comentarios converter(OrdemServico ordemServico, ExecutorOSRepository executorOsRep,
			ComentariosRepository comentariosRepository) {
		ExecutorOrdemServico executorOs = executorOsRep.findById(this.executorComentario)
				.orElseThrow(() -> new EntityNotFoundException("Executor não encontrado."));
		
		Comentarios novoComentario = new Comentarios();
		novoComentario.setOrdemServico(ordemServico);
		novoComentario.setExecutorOs(executorOs);
		novoComentario.setMensagem(this.descricaoComentario);
		return comentariosRepository.save(novoComentario);

	}

}
>>>>>>> 582d4c0d73dd8a2a3149de2ef90ed4dcb92d373c

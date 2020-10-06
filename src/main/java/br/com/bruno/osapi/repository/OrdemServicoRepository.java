package br.com.bruno.osapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruno.osapi.modelo.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

	List<OrdemServico> findByExecutorOrdemServico_Nome(String nomeExecutor);
	List<OrdemServico> findByCliente(Long clientId);
	List<OrdemServico> findByComentariosIsNotEmpty();	
	
}

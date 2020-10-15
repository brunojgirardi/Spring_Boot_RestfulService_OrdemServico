package br.com.bruno.osapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.bruno.osapi.modelo.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

	List<OrdemServico> findByExecutorOrdemServico_Nome(String nomeExecutor);
	
	//jpql
	@Query("SELECT t FROM OrdemServico t WHERE t.executorOrdemServico.nome = :nomeExecutor")
	List<OrdemServico> carregarPorOrdemServicoNome(@Param("nomeExecutor") String nomeExecutor);
	
	List<OrdemServico> findByCliente(Long clientId);
	List<OrdemServico> findByComentariosIsNotEmpty();	
	
}

package br.com.bruno.osapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruno.osapi.modelo.ExecutorOrdemServico;

public interface ExecutorOSRepository extends JpaRepository<ExecutorOrdemServico, Long> {

	List<ExecutorOrdemServico> findByNome(String nomeExcecutorOs);

}

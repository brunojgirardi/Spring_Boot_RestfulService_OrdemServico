<<<<<<< HEAD
package br.com.bruno.osapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruno.osapi.modelo.ExecutorOrdemServico;

public interface ExecutorOSRepository extends JpaRepository<ExecutorOrdemServico, Long> {

	List<ExecutorOrdemServico> findByNome(String nomeExecutorOs);

}
=======
package br.com.bruno.osapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruno.osapi.modelo.ExecutorOrdemServico;

public interface ExecutorOSRepository extends JpaRepository<ExecutorOrdemServico, Long> {

	List<ExecutorOrdemServico> findByNome(String nomeExecutorOs);

}
>>>>>>> 582d4c0d73dd8a2a3149de2ef90ed4dcb92d373c

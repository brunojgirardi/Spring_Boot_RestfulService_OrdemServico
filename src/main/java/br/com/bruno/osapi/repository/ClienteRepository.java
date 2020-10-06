<<<<<<< HEAD
package br.com.bruno.osapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruno.osapi.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByNome(String nomeCliente);
	Cliente findByEmail(String emailCliente);

}
=======
package br.com.bruno.osapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruno.osapi.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByNome(String nomeCliente);
	Cliente findByEmail(String emailCliente);

}
>>>>>>> 582d4c0d73dd8a2a3149de2ef90ed4dcb92d373c

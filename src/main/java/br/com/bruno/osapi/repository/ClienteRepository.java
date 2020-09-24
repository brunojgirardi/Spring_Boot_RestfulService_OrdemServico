package br.com.bruno.osapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruno.osapi.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findByNome(String nomeCliente);
	Cliente findByEmail(String emailCliente);

}

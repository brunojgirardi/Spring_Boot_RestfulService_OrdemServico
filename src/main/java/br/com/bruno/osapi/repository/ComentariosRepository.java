package br.com.bruno.osapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bruno.osapi.modelo.Comentarios;

public interface ComentariosRepository extends JpaRepository<Comentarios, Long> {

}

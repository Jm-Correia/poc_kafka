package br.com.spy.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import antlr.debug.Event;
import br.com.spy.eventos.entity.Evento;

@Repository
public interface EventoRepo extends JpaRepository<Evento, Long> {

}

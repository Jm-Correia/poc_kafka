package br.com.spy.eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spy.eventos.entity.LogProcesso;

@Repository
public interface LogProcessoRepo extends JpaRepository<LogProcesso, Long> {

}

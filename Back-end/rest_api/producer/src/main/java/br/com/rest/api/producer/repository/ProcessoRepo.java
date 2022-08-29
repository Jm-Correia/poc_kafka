package br.com.rest.api.producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rest.api.producer.entity.Processo;

@Repository
public interface ProcessoRepo extends JpaRepository<Processo, String> {

}

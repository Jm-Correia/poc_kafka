package br.com.rest.api.producer.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rest.api.producer.dtos.CadastroDTO;
import br.com.rest.api.producer.entity.Processo;
import br.com.rest.api.producer.repository.ProcessoRepo;

@Service
public class CadastrarProcesso {

	@Autowired
	private ProcessoRepo repo;
	
	public Processo cadastrarProcesso(CadastroDTO dto) {
		Processo processo = new Processo(UUID.randomUUID().toString(), LocalDate.now(), 1, "");
		repo.save(processo);
		return processo;
	}
}

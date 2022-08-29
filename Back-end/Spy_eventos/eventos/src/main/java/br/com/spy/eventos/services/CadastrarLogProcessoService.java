package br.com.spy.eventos.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.spy.eventos.entity.Evento;
import br.com.spy.eventos.entity.LogProcesso;
import br.com.spy.eventos.repository.EventoRepo;
import br.com.spy.eventos.repository.LogProcessoRepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CadastrarLogProcessoService {

	
	private LogProcessoRepo processoRepo;
	private EventoRepo eventoRepo;
	
	@Autowired
	CadastrarLogProcessoService(LogProcessoRepo repo, EventoRepo eventoRepo){
		this.processoRepo = repo;
		this.eventoRepo = eventoRepo;
	}
	
	@Transactional
	public void cadastrarEvento(LogProcesso entity, String descricao) {
		LogProcesso newLogProcesso = new LogProcesso();
		newLogProcesso.setUuid(entity.getUuid());
		var processoExist = processoRepo.findOne(Example.of(newLogProcesso));
		
		log.info("Processo Exist? {}", processoExist.isPresent());
		if(!processoExist.isPresent()) {
			processoRepo.save(entity);
			Evento evento = new Evento(null, LocalDate.now(), descricao, entity.getId());
			eventoRepo.save(evento);
			
		} else {
			var oldProcesso = processoExist.get();
			Evento evento = new Evento(null, entity.getCreateAt(), descricao, oldProcesso.getId());
			eventoRepo.save(evento);
		}
		
	
	}
}

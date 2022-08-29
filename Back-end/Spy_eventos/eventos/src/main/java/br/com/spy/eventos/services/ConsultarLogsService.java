package br.com.spy.eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spy.eventos.entity.Evento;
import br.com.spy.eventos.repository.EventoRepo;

@Service
public class ConsultarLogsService {

	@Autowired
	private EventoRepo eventoRepo;
	
	public List<Evento> eventos(){
		return eventoRepo.findAll();
	}
	
}

package br.com.spy.eventos.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spy.eventos.services.ConsultarLogsService;

@RestController
@RequestMapping(value = "/logs")
public class ConsultarLogAndEventos {

	@Autowired
	private ConsultarLogsService service;
	
	@GetMapping
	public ResponseEntity<?> consultar(){
		return ResponseEntity.ok(service.eventos());
	}
	
}

package br.com.rest.api.producer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.api.producer.dtos.CadastroDTO;
import br.com.rest.api.producer.service.KafkaClient;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/pessoa")
@RequiredArgsConstructor
public class CadastroController {

	
	private final KafkaClient client;
	
	@PostMapping()
	public ResponseEntity<?> cadastrar(@Validated @RequestBody CadastroDTO dto){
		client.sendCadastroCheck(dto);
		return ResponseEntity.noContent().build();
	}
	
}

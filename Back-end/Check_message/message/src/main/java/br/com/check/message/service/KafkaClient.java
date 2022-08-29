package br.com.check.message.service;

import javax.transaction.Transactional;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.check.message.dtos.CadastroDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaClient {

	private final KafkaTemplate<String, CadastroDTO> kafkaTemplate;
	
	private static final String TOPIC_NAME = "FALL_CADASTRO_TOPIC";
	
	
	public void sendCadastroCheck(CadastroDTO dto) {
		
		kafkaTemplate.send(TOPIC_NAME, dto);
	}
	
}

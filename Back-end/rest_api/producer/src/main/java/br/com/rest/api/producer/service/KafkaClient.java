package br.com.rest.api.producer.service;

import javax.transaction.Transactional;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.rest.api.producer.dtos.CadastroDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KafkaClient {

	private final KafkaTemplate<String, CadastroDTO> kafkaTemplate;
	
	private final CadastrarProcesso cadastrarProcessoService;
	
	private static final String TOPIC_NAME = "CHECK_CADASTRO_TOPIC";
	
	@Transactional
	public void sendCadastroCheck(CadastroDTO dto) {
		var processo = cadastrarProcessoService.cadastrarProcesso(dto);
		dto.setIdProcesso(processo.getUuid());
		kafkaTemplate.send(TOPIC_NAME, dto);
	}
	
}

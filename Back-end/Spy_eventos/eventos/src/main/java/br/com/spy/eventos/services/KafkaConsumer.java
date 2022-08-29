package br.com.spy.eventos.services;

import java.time.LocalDate;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.spy.eventos.dtos.CadastroDTO;
import br.com.spy.eventos.entity.LogProcesso;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {


	private static final String TOPIC_NAME = "CHECK_CADASTRO_TOPIC";
	
	private final CadastrarLogProcessoService service;
	
	@KafkaListener(topics = TOPIC_NAME, groupId = "group-check")
	public void listenTopic(CadastroDTO dto) {
		try {
			log.info("Lendo informacoes do topico: {} , info: {} ", TOPIC_NAME, dto.getIdProcesso());
			LogProcesso logProcesso = new LogProcesso(null,dto.getIdProcesso(), LocalDate.now(), 1);
			
			service.cadastrarEvento(logProcesso, dto.getDescricao());
		}catch(Exception ex) {
			log.info("Error when read the topic. {} ", TOPIC_NAME);
			ex.printStackTrace();			
		}
	}
	
}

package br.com.check.message.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.check.message.dtos.CadastroDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {


	private static final String TOPIC_NAME = "CHECK_CADASTRO_TOPIC";
	private static final Integer YEARS_MAX = 50;
	
	private final KafkaClient client;
	
	
	@KafkaListener(topics = TOPIC_NAME, groupId = "group")
	public void listenTopic(CadastroDTO dto) {
		try {
			log.info("Lendo informacoes do topico: {} , info: {} ", TOPIC_NAME, dto.getIdProcesso());
			
			var age = Period.between(dto.getDtNascimento(), LocalDate.now()).getYears();
			if(age > YEARS_MAX) {
				log.info("Idade acima do esperado {} , cadastro negado", age);
				dto.setDescricao("Cadastro NEGADO por causa da idade");
				client.sendCadastroCheck(dto);
			}
			
		}catch(Exception ex) {
			log.info("Error when read the topic. {} ", TOPIC_NAME);
			ex.printStackTrace();			
		}
	}
	
}

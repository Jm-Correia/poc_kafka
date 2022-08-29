package br.com.spy.eventos.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import br.com.spy.eventos.dtos.CadastroDTO;


@Configuration
public class KafkaConfig {

	@Value(value="${kafka.bootstrapAddress}")
	private String bootstrapAddress;
	
	public ProducerFactory<String, CadastroDTO> producerFactory(){
		Map<String, Object> configs = new HashMap<>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		configs.put(ProducerConfig.CLIENT_ID_CONFIG, "cadastri-api");
		
		return new DefaultKafkaProducerFactory<>(configs);
	}
	
	@Bean
	public KafkaTemplate<String, CadastroDTO> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
	
	public ConsumerFactory<String, CadastroDTO> consumerFactory(){
		JsonDeserializer<CadastroDTO> deserializer = new JsonDeserializer<>(CadastroDTO.class);
		deserializer.addTrustedPackages("*");
		deserializer.setRemoveTypeHeaders(false);
		deserializer.setUseTypeMapperForKey(true);
		
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		
		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, CadastroDTO> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, CadastroDTO> factory = new ConcurrentKafkaListenerContainerFactory();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
}

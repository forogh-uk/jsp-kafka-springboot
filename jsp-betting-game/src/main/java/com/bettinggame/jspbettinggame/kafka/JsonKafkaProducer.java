package com.bettinggame.jspbettinggame.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.messaging.Message;

import com.bettinggame.jspbettinggame.domain.Bet;

//kafka producer to produce json message and send that just as a message to the kafka topic

@Service
public class JsonKafkaProducer {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaProducer.class);
	//inject kafka template
	
	private KafkaTemplate<String, Bet> kafkaTemplate;
	public JsonKafkaProducer(KafkaTemplate<String, Bet> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(Bet data) {
		LOGGER.info(String.format("Message send -> %s", data.toString()));
		Message<Bet> message = MessageBuilder
				.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, "betting")
				.build();
		kafkaTemplate.send(message);
		
	}
	
	

}

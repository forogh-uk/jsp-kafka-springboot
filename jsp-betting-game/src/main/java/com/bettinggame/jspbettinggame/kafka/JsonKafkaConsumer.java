package com.bettinggame.jspbettinggame.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.bettinggame.jspbettinggame.domain.Bet;

@Service
public class JsonKafkaConsumer {
	
	private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics = "betting", groupId = "bettingGroup")
	
	public void consume(Bet bet) {
		LOGGER.info(String.format("Message recived -> %s", bet.toString()));
	}

}

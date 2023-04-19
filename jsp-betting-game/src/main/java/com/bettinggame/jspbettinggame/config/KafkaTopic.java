package com.bettinggame.jspbettinggame.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {
	
	@Bean
	public NewTopic kafkaTopicConfig() {
		return TopicBuilder.name("betting")
				.build();
		
	}

}

package com.bettinggame.jspbettinggame;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.bettinggame.jspbettinggame.domain.Bet;
import com.bettinggame.jspbettinggame.service.BettingService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication

public class JspBettingGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(JspBettingGameApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(BettingService bettingService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Bet>> typeReference = new TypeReference<List<Bet>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/bet.json");
			try {
				List<Bet> bets = mapper.readValue(inputStream,typeReference);
				bettingService.save(bets);
				System.out.println("Bets Saved!");
			} catch (IOException e){
				System.out.println("Unable to save bets: " + e.getMessage());
			}
		};
	}

}
